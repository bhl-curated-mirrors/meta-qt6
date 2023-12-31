LICENSE = "GFDL-1.3 & BSD-3-Clause & ( GPL-3.0-only & The-Qt-Company-GPL-Exception-1.0 ) & ( GPL-2.0-or-later | LGPL-3.0-only ) | The-Qt-Company-Commercial"
LIC_FILES_CHKSUM = " \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
"

inherit qt6-cmake

include recipes-qt/qt6/qt6-git.inc
include recipes-qt/qt6/qt6-lts.inc
include recipes-qt/qt6/qt6.inc

DEPENDS += "qtbase qtshadertools qtshadertools-native"

PACKAGECONFIG ?= "gstreamer qml"
PACKAGECONFIG[alsa] = "-DFEATURE_alsa=ON,-DFEATURE_alsa=OFF,alsa-lib"
PACKAGECONFIG[examples] = "-DQT_BUILD_EXAMPLES=ON,-DQT_BUILD_EXAMPLES=OFF,qtsvg"
PACKAGECONFIG[pulseaudio] = "-DFEATURE_pulseaudio=ON,-DFEATURE_pulseaudio=OFF,pulseaudio"
PACKAGECONFIG[gstreamer] = "-DFEATURE_gstreamer=ON,-DFEATURE_gstreamer=OFF,gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"
PACKAGECONFIG[qml] = ",,qtdeclarative qtdeclarative-native"

EXTRA_OECMAKE += "-DFEATURE_gpu_vivante=OFF"

