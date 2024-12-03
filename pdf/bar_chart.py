import matplotlib.pyplot as plt
import numpy as np


categories = ['Padrão', 'Customizado', 'JSON', 'XML', 'Protobuf']
compra_sizes = [475, 486, 499, 568, 274]  
agenda_sizes = [1199998, 1197660, 1199956, 1199362, 1197724]  

index = np.arange(len(categories))

fig, ax = plt.subplots(figsize=(10, 6))
ax.bar(index, compra_sizes, color='b', label='Compra')
ax.set_xlabel('Protocolos')
ax.set_ylabel('Tamanho (Bytes)')
ax.set_title('Lista de Compra')
ax.set_xticks(index)
ax.set_xticklabels(categories)
ax.legend()
plt.tight_layout()
plt.savefig('imgs/compra_data_size.png', dpi=300) 
plt.close()  


fig, ax = plt.subplots(figsize=(10, 6))
ax.bar(index, agenda_sizes, color='g', label='Agenda')
ax.set_xlabel('Protocolos')
ax.set_ylabel('Tamanho (Bytes)')
ax.set_title('Agenda de Contatos')
ax.set_xticks(index)
ax.set_xticklabels(categories)
ax.set_ylim(1.1e6, max(agenda_sizes) * 1.1)  
ax.legend()
plt.tight_layout()
plt.savefig('imgs/agenda_data_size.png', dpi=300)  
plt.close()  
