#include "mainwindow.hpp"
#include "ui_mainwindow.h"

#include "cell.hpp"

#include <qjson/parser.h>
#include <qjson/serializer.h>
#include <QtCore/QDebug>
#include <QtGui/QFileDialog>
#include <QtGui/QMessageBox>

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent), _ui(new Ui::MainWindow) {
    _height = 1;
    _width = 1;
    _ui->setupUi(this);
    setCentralWidget(new QWidget(this));
    _centerLayout = NULL;
    _fileName = QString::null;
}

MainWindow::~MainWindow() {
    delete _ui;
}

void MainWindow::newMap() {
    QWidget *tmp = new QWidget(this);
    _centerLayout = new QGridLayout(tmp);
    _centerLayout->setSpacing(0);
    tmp->setLayout(_centerLayout);
    setCentralWidget(tmp);

    for (unsigned int i = 0; i < _height; ++i) {
        for (unsigned int j = 0; j < _width; ++j) {
            Cell *tmp = new Cell(this);
            tmp->setTerrainType(Cell::GRASS);
            tmp->setHeight(0);
            _centerLayout->addWidget(tmp, i, j);
        }
    }
}

void MainWindow::sizeChanged() {
    unsigned int oldHeight = _height;
    unsigned int oldWidth = _width;
    _height = _ui->spinHaut->value();
    _width = _ui->spinLarg->value();

    if (!_centerLayout)
        return;

    if (_height < oldHeight) {
        for (unsigned int i = _height; i < oldHeight; ++i) {
            for (unsigned int j = 0; j < oldWidth; ++j) {
                _centerLayout->removeItem(_centerLayout->itemAtPosition(_height, j));
            }
        }
    } else if (_height > oldHeight) {
        for (unsigned int i = oldHeight; i < _height; ++i) {
            for (unsigned int j = 0; j < oldWidth; ++j) {
                Cell *tmp = new Cell(this);
                tmp->setTerrainType(Cell::FOREST);
                tmp->setHeight(0);
                _centerLayout->addWidget(tmp, i, j);
            }
        }
    }

    if (_width < oldWidth) {
        for (unsigned int i = _width; i < oldWidth; ++i) {
            for (unsigned int j = 0; j < _height; ++j) {
                _centerLayout->removeItem(_centerLayout->itemAtPosition(j, _width));
            }
        }
    } else if (_width > oldWidth) {
        for (unsigned int i = oldWidth; i < _width; ++i) {
            for (unsigned int j = 0; j < _height; ++j) {
                Cell *tmp = new Cell(this);
                tmp->setTerrainType(Cell::FOREST);
                tmp->setHeight(0);
                _centerLayout->addWidget(tmp, j, i);
            }
        }
    }

    centralWidget()->repaint();
}

void MainWindow::openMap() {
    openMap(QFileDialog::getOpenFileName(this, "Open a file", QString(), "Map (*.map *.json)"));
}

void MainWindow::quit() {
    qApp->exit();
}

void MainWindow::save() {
    if (_fileName == QString::null) {
        saveAs();
        return;
    }

    QString out;

    out = "[";

    bool rowFirstPass = true;

    for (int i = 0; i < _centerLayout->rowCount(); ++i) {
        if (!rowFirstPass)
            out.append(",");
        else
            rowFirstPass = false;
        out.append(" [");

        bool cellFirstPass = true;
        for (int j = 0; j < _centerLayout->columnCount(); ++j) {
            Cell* c = dynamic_cast<Cell*>(_centerLayout->itemAtPosition(i, j)->widget());
            QVariantMap variant;
            variant.insert("height", c->height());
            switch (c->terrainType()) {
            case Cell::GRASS:
                variant.insert("type", "grass");
                break;
            case Cell::SNOW:
                variant.insert("type", "snow");
                break;
            case Cell::WATER:
                variant.insert("type", "water");
                break;
            case Cell::FOREST:
                variant.insert("type", "forest");
                break;
            case Cell::ROCK:
                variant.insert("type", "rock");
                break;
            case Cell::SWAMP:
                variant.insert("type", "swamp");
                break;
            case Cell::SAND:
                variant.insert("type", "sand");
                break;
            case Cell::AIR:
                variant.insert("type", "air");
                break;
            default:
                variant.insert("type", "none");
                break;
            }
            QJson::Serializer serializer;
            if (!cellFirstPass)
                out.append(", ");
            else
                cellFirstPass = false;
            out.append(serializer.serialize(variant));
        }
        out.append(" ]");
    }
    out.append(" ]");

    QFile file(_fileName);
    if (!file.open(QIODevice::WriteOnly | QIODevice::Text)) {
        QMessageBox::critical(this, "Error", "Unable to open " + _fileName);
        return;
    }
    file.write(out.toAscii());

    file.close();
}

void MainWindow::saveAs() {
    _fileName = QFileDialog::getSaveFileName(this, "Open a file", QString(), "Map (*.map *.json");
    save();
}

void MainWindow::openMap(const QString &fileName) {
    QFile file(fileName);
    if (!file.open(QIODevice::ReadOnly | QIODevice::Text)) {
        QMessageBox::critical(this, "Error", "Unable to open " + fileName);
        return;
    }

    QByteArray json = file.readAll();

    QJson::Parser parser;
    bool ok;
    QList<QVariant> res = parser.parse(json, &ok).toList();
    if (!ok) {
        QMessageBox::critical(this, "Error", "Error reading " + fileName);
        return;
    }

    if (res.size() == 0)
        return;
    if (res[0].toList().size() == 0)
        return;

    _fileName = fileName;
    newMap();

    _ui->spinHaut->setValue(res.size());
    _ui->spinLarg->setValue(res[0].toList().size());
    sizeChanged();

    for (int i = 0; i < res.size(); ++i) {
        QList<QVariant> row = res[i].toList();
        for (int j = 0; j < row.size(); ++j) {
            QVariantMap cell = row[j].toMap();
            Cell* tmp = new Cell;
            tmp->setHeight(cell["height"].toInt());
            QString ttype = cell["type"].toString();
            if (ttype == "grass")
                tmp->setTerrainType(Cell::GRASS);
            else if (ttype == "snow")
                tmp->setTerrainType(Cell::SNOW);
            else if (ttype == "water")
                tmp->setTerrainType(Cell::WATER);
            else if (ttype == "forest")
                tmp->setTerrainType(Cell::FOREST);
            else if (ttype == "rock")
                tmp->setTerrainType(Cell::ROCK);
            else if (ttype == "swamp")
                tmp->setTerrainType(Cell::SWAMP);
            else if (ttype == "sand")
                tmp->setTerrainType(Cell::SAND);
            else if (ttype == "air")
                tmp->setTerrainType(Cell::AIR);
            else
                tmp->setTerrainType(Cell::GRASS);
            _centerLayout->addWidget(tmp, i, j);
        }
    }
    file.close();
}
