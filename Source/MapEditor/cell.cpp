#include "cell.hpp"

#include <QtCore/QDebug>
#include <QtGui/QMouseEvent>

Cell::Cell(QWidget *parent) : QLabel(parent) {
    setTerrainType(GRASS);
    setHeight(0);
    setAutoFillBackground(true);
}

void Cell::setTerrainType(ETerrainType type) {
    _type = type;
    setColor(computeColor());
}

void Cell::setHeight(int height) {
    _height = height;
    setText(QString::number(_height));
    setColor(computeColor());
}

void Cell::mouseReleaseEvent(QMouseEvent *evt) {
    if (evt->button() == Qt::LeftButton) {
        setHeight(_height + 1);
    } else if (evt->button() == Qt::RightButton) {
        setHeight(_height - 1);
    }
}

void Cell::wheelEvent(QWheelEvent *evt) {
    if (evt->delta() > 0)
        setTerrainType((ETerrainType)(((int)_type + 1) % (int)COUNT));
    else
        setTerrainType((ETerrainType)(((int)_type - 1) % (int)COUNT));
}

void Cell::setColor(const QColor &color) {
    QPalette pal = palette();
    pal.setColor(backgroundRole(), color);
    pal.setColor(foregroundRole(), (qMax(qMax(color.red(), color.green()), color.blue()) >= 128) ? Qt::black : Qt::white);
    setPalette(pal);
}

QColor Cell::computeColor() const {
    QColor res;
    switch (_type) {
    case GRASS:
        res = Qt::green;
        break;
    case SNOW:
        res = Qt::white;
        break;
    case WATER:
        res = Qt::blue;
        break;
    case FOREST:
        res = Qt::green;
        res = res.darker();
        break;
    case ROCK:
        res = Qt::red;
        res = res.lighter();
        break;
    case SWAMP:
        res = Qt::green;
        res = res.darker();
        res = res.darker();
        break;
    case SAND:
        res = Qt::yellow;
        res = res.lighter();
        res = res.lighter();
        break;
    case AIR:
        res = Qt::white;
        break;
    case COUNT:
        res = Qt::black;
        break;
    }

    int base = _height - 5;
    return base < 0 ? res.darker(-base * 50) : res.lighter(base * 50);
}
