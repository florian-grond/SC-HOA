# SC-HOA

[HOA](https://en.wikipedia.org/wiki/Ambisonics#Higher-order_Ambisonics) for [SuperCollider](http://supercollider.github.io/).

## Overview

The HOA library provides classes to encode, transform and decode Higher Order Ambisonics sound signals up to order 5. The basis for the library are UGens compiled from Faust code written by Pierre Lecomte, see [ambitools][1]. Documentation and tutorials are partly based on the [ambitools documentation](https://github.com/sekisushai/ambitools/blob/master/Documentation/documentation.pdf) (pdf).

Additional plane wave encoders and optimizers have been added, adpated from [CICM](http://cicm.mshparisnord.org/)'s [HoaLibrary](http://hoalibrary.mshparisnord.fr/) and [Aaron Heller](https://www.sri.com/about/people/aaron-j-heller)'s [ambidecodertoolbox](https://bitbucket.org/ambidecodertoolbox/adt.git).  

The SuperCollider library was written by [Florian Grond](http://www.grond.at). It includes soundfield recordings made together with Romain Dumoulin using the Eigenmike from [CIRMMT](http://www.cirmmt.org).

Frontend classes are wrappers that select the correct low-level UGen depending on the intended ambisonics order. The b-format signal is encapsulated in a channel array, which makes the resulting SC code flexible to experiment with different orders e.g. to account for available computational resources. All arguments obey SuperCollider's Multichannel Expansion paradigm.

Additional resources for SC-HOA ambisonics are found inside the [resources/](resources/) folder. The included [FIR filters](resources/kernels/FIR/) are taken from [ambitools][1]. The [binraural IRs](resources/kernels/binauralIRs/) and [heaphone EQs](resources/kernels/headphoneEQ/) are taken from the [IEM Plugin Suite](https://git.iem.at/audioplugins/IEMPluginSuite)'s BinauralDecoder.

## Installation

To install the SC-HOA quark, either use the `Quarks.gui` interface or install it manually:

```Quarks.install("https://github.com/florian-grond/SC-HOA")```

In order to use this library, you will need a collection of SuperCollider UGens called _HOAUGens_. These UGens are available as part of the [sc3-plugins](https://supercollider.github.io/sc3-plugins/). See the website and GitHub repository for installation instructions. 

> **note:** The HOAUGens were added to the sc3-plugins as of commit https://github.com/supercollider/sc3-plugins/commit/9326e1229a64ca82f76124a7a1a038095be22996
 
If you need 3rd order recordings for testing the tutorial and radial filters, feel free to [contact me](http://www.grond.at/html/submenues/submenu_contact.htm).

## Acknowledgements

The implementation of SC-HOA was supported by a postdoctoral fellowship of Fonds de Recherche du Québec - Société et Culture (FRQSC) http://www.frqsc.gouv.qc.ca/ conducted at CIRMMT https://www.cirmmt.org/ and through the Metalab at the Société des Arts Technologiques http://sat.qc.ca/ in Montreal.

=======

Special thanks for code contribition and discussion goes to Nicolas Bouillot, Michal Seta, Till Bovermann, Carlo Capocasa, Thibaud Keller and Julian Rohrhuber.

[1]: https://github.com/sekisushai/ambitools
