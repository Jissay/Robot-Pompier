#-------------------------------------------------
#
# Project created by QtCreator 2012-03-08T21:08:15
#
#-------------------------------------------------

QT       += core gui

TARGET = MapEditor
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    cell.cpp

HEADERS  += mainwindow.hpp \
    cell.hpp

FORMS    += mainwindow.ui

LIBS += -lqjson
