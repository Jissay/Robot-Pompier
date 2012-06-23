#ifndef __MAINWINDOW_HPP__
#define __MAINWINDOW_HPP__

#include <QtGui/QGridLayout>
#include <QtGui/QMainWindow>

namespace Ui {
    class MainWindow;
}

class MainWindow : public QMainWindow {

    Q_OBJECT
    
public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void sizeChanged();
    void newMap();
    void openMap();
    void quit();
    void save();
    void saveAs();
    
private:
    Ui::MainWindow*         _ui;
    QGridLayout*            _centerLayout;
    unsigned int            _height;
    unsigned int            _width;
    QString                 _fileName;

    void openMap(const QString &fileName);
};

#endif // __MAINWINDOW_HPP__
