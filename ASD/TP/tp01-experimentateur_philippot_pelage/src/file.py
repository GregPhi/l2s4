# -*- coding: utf-8 -*-

"""
:mod:`file` module : create the different file.dat for n markers et m positive

:author: `Grégoire Philippot et François Xavier Pelage`_

:date: 2015, december
"""

import sys
import experience
import sorting
import test

if __name__ == "__main__":
    n = int(sys.argv[1])
    fil = str(sys.argv[2])
    test.file(n,fil)
