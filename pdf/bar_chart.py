import matplotlib.pyplot as plt
import numpy as np

# Data
categories = ['simples', 'custom', 'json', 'xml', 'proto']
compra_sizes = [475, 486, 499, 568, 274]  # Data for "compra"
agenda_sizes = [1199998, 1197660, 1199956, 1199362, 1197724]  # Data for "agenda"

# Bar width and positions
index = np.arange(len(categories))

# Create and save the "Compra" plot
fig, ax = plt.subplots(figsize=(10, 6))
ax.bar(index, compra_sizes, color='b', label='Compra')
ax.set_xlabel('Data Type')
ax.set_ylabel('Size (Bytes)')
ax.set_title('Compra Data Size')
ax.set_xticks(index)
ax.set_xticklabels(categories)
ax.legend()
plt.tight_layout()
plt.savefig('imgs/compra_data_size.png', dpi=300)  # Save Compra plot as PNG
plt.close()  # Close the plot to avoid overlapping with the next one

# Create and save the "Agenda" plot
fig, ax = plt.subplots(figsize=(10, 6))
ax.bar(index, agenda_sizes, color='g', label='Agenda')
ax.set_xlabel('Data Type')
ax.set_ylabel('Size (Bytes)')
ax.set_title('Agenda Data Size')
ax.set_xticks(index)
ax.set_xticklabels(categories)
ax.set_ylim(1.1e6, max(agenda_sizes) * 1.1)  # Ajustar o limite inferior do eixo Y para 1e6
ax.legend()
plt.tight_layout()
plt.savefig('imgs/agenda_data_size.png', dpi=300)  # Save Agenda plot as PNG
plt.close()  # Close the plot to avoid overlap
