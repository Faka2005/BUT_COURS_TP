import numpy as np
import matplotlib.pyplot as plt

x=np.arange(1,6)
probas=(1/10)*(3-x)*(3-x)
print('espe=',np.sum(x*probas))
print('var=',np.sum((x-np.sum(x*probas))**2*probas))

probas_cum=[sum(probas[:(i+1)]) for i in range(probas.size)]

f,(ax1,ax2)=plt.subplots(1,2)
ax1.bar(x,probas)

x_rep=np.copy(x)
probas_cum_rep=np.copy(probas_cum)
x_rep=np.insert(x_rep,0,-1)
probas_cum_rep=np.insert(probas_cum_rep,0,0)
x_rep=np.insert(x_rep,6,7)
probas_cum_rep=np.insert(probas_cum_rep,6,1)

for i in range(x_rep.size-1):
    ax2.plot([x_rep[i],x_rep[i+1]],[probas_cum_rep[i],probas_cum_rep[i]],'b')
plt.show()