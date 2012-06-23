#ifndef __CELL_HPP__
#define __CELL_HPP__

#include <QtGui/QLabel>

class Cell : public QLabel {

    Q_OBJECT

    Q_PROPERTY(ETerrainType type READ terrainType WRITE setTerrainType)
    Q_PROPERTY(int height READ height WRITE setHeight)
    Q_ENUMS(ETerrainType)

public:
    enum ETerrainType {
        GRASS = 0,
        SNOW = 1,
        WATER = 2,
        FOREST = 3,
        ROCK = 4,
        SWAMP = 5,
        SAND = 6,
        AIR = 7,
        COUNT = 8
    };

    explicit Cell(QWidget *parent = 0);

    inline ETerrainType terrainType() const {
        return _type;
    }

    inline int height() const {
        return _height;
    }

    void setTerrainType(ETerrainType type);
    void setHeight(int height);

protected:
    virtual void mouseReleaseEvent(QMouseEvent *evt);
    virtual void wheelEvent(QWheelEvent *evt);
    
private:
    ETerrainType    _type;
    int             _height;

    void setColor(const QColor &color);
    QColor computeColor() const;
};

#endif // __CELL_HPP__
