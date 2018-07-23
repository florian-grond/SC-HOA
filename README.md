# SC-HOA

[HOA](https://en.wikipedia.org/wiki/Ambisonics#Higher-order_Ambisonics) for [SuperCollider](http://supercollider.github.io/).

## Overview

The HOA library provides classes to encode, transform and decode Higher Order Ambisonics sound signals up to order 5. The basis for the library are UGens compiled from Faust code written by Pierre Lecomte, see [ambitools](https://github.com/sekisushai/ambitools). Documentation and tutorials are partly based on the [ambitools documentation](https://github.com/sekisushai/ambitools/blob/master/Documentation/documentation.pdf) (pdf).

The SuperCollider library was written by [Florian Grond](http://www.grond.at). It includes soundfield recordings made together with Romain Dumoulin using the Eigenmike from [CIRMMT](http://www.cirmmt.org).

Frontend classes are wrappers that select the correct low-level UGen depending on the intended ambisonics order. The b-format signal is encapsulated in a channel array, which makes the resulting SC code flexible to experiment with different orders e.g. to account for available computational resources. All arguments obey SuperCollider's Multichannel Expansion paradigm.

[^1]: binary files are not included in this repository, see [Installation](#Installation) for details.

## Installation

Installing the SC-HOA quark:

Either use the Quarks.gui interface or install the quark manually:

Quarks.install("https://github.com/florian-grond/SC-HOA");

In order to use the library you also need to install the HOA plugins.
A PR to the SC3 plugins has been submitted, meanwhile you find compile instructions for SC3plugins + HOA here:
https://github.com/florian-grond/sc3-pluginsHOA
(compiled plugins SC3plugins for 3.8 and 3.9 with supernova support are also provided at this link)

There are additional sources you might need e.g. FIR filters for binaural decoding:
Download them here https://github.com/sekisushai/ambitools and place the downloaded FIR folder in the HOA/kernels folder.
Depending on the platform you have this is:
~/.local/share/HOA/kernels/ or ~/Library/Application Support/HOA/kernels/
You can find the right path by executing

HOA.userSupportDir

3rd order recordings for testing the tutorial and radial filters). Please [contact](http://www.grond.at/html/submenues/submenu_contact.htm) me if you need them.

## Acknowledgements

The implementation of SC-HOA was supported by a postdoctoral fellowship of Fonds de Recherche du Québec - Société et Culture (FRQSC) http://www.frqsc.gouv.qc.ca/ conducted at CIRMMT https://www.cirmmt.org/ and through the Metalab at the Société des Arts Technologiques http://sat.qc.ca/ in Montreal.
Special thanks goes to Nicolas Bouillot, Michal Seta, Till Bovermann and Carlo Capocasa.
