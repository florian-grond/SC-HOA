# SC-HOA

[HOA](https://en.wikipedia.org/wiki/Ambisonics#Higher-order_Ambisonics) for [SuperCollider](http://supercollider.github.io/), based on [ambitools](https://github.com/sekisushai/ambitools).

## Overview

The HOA library provides classes to encode, transform and decode Higher Order Ambisonics sound signals up to order 5. The basis for the library are UGens compiled from Faust code written by Pierre Lecomte. Documentation and tutorials are partly based on the [ambitools documentation](https://github.com/sekisushai/ambitools/blob/master/Documentation/documentation.pdf) (pdf).

The SuperCollider library was written by [Florian Grond](http://www.grond.at). It includes soundfield recordings[^1] made together with Romain Dumoulin using the Eigenmike from [CIRMMT](http://www.cirmmt.org).

Frontend classes are wrappers that select the correct low-level UGen depending on the intended ambisonics order. The b-format signal is encapsulated in a channel array, which makes the resulting SC code flexible to experiment with different orders e.g. to account for available computational resources. All arguments obey SuperCollider's Multichannel Expansion paradigm.

[^1]: binary files are not included in this repository, see [Install](#install) for details.

## Install

This repository contains several folders as described below. 
There are additional sources you might need (FIR filters, 3rd order recordings for testing the tutorial and radial filters). Please [contact](http://www.grond.at/html/submenues/submenu_contact.htm) me if you need them.


### `HOA` 

Contains classes, pseudo-`UGens`, help and tutorial files.
Should be installed either 

in the extensions folder 

```Platform.userExtensionDir; // see below```

or included in the the Language configuration file, either via IDE preferences (Interpreter/Include), or by running 

```LanguageConfig.addIncludePath("/path/to/HOA")```

help and tutorial files are then accessible via the help system from within SuperCollider. An entry-point to the documentation is e.g. the `HOA` class documentation.

### `HOAplugins`

The FAUST-generated CPP sources, ready to be compiled into plugins. The compilation requires [faust](http://faust.grame.fr/) headers (via [git repository](https://github.com/grame-cncm/faust)) and SuperCollider headers to be installed on your system.
The resulting plugins (`.scx, .sc` on OSX, `.so, .sc` on linux) should be installed as described below.

### `HOAplugins_compiled`

Pre-compiled plugins (OSX, linux). 
Should be installed in the extensions folder: 

```
// return path of the user extension directory by running 
Platform.userExtensionDir;

// open user extension directory
Platform.userExtensionDir.openOS;
```
