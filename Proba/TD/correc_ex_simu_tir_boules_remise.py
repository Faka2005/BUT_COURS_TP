import numpy as np
import math as mt


def bouleb(n,nb):
    simu=np.random.rand(n,4)
    test=np.count_nonzero(simu<0.7,axis=1)
    return np.count_nonzero(test==nb)/n

print(bouleb(100000,2))
print(1-bouleb(100000,0))

print('vraie proba d avoir 2 bb : ',mt.comb(4,2)*0.7**2*0.3**2)
print('vraie proba d avoir au moins 1 bb : ',1-mt.comb(4,0)*0.7**0*0.3**4)