import tkinter as tk
from tkinter import ttk, messagebox

# Clases del modelo
class Producto:
    def __init__(self, nombre, precio, categoria):
        self.nombre = nombre
        self.precio = precio
        self.categoria = categoria

    def mostrar_info(self):
        return f"Nombre del producto: {self.nombre}, Precio: {self.precio}, Categoria: {self.categoria.nombre}"

class Cliente:
    def __init__(self, nombre, apellido, id_cliente):
        self.nombre = nombre
        self.apellido = apellido
        self.id_cliente = id_cliente

    def mostrar_info(self):
        return f"Nombre: {self.nombre} {self.apellido}, ID: {self.id_cliente}"

class Orden:
    def __init__(self, cliente):
        self.cliente = cliente
        self.items = []
        self.total = 0.0

    def agregar_item(self, item):
        self.items.append(item)
        self.calcular_total()

    def calcular_total(self):
        self.total = sum(item.calcular_subtotal() for item in self.items)

    def mostrar_info(self):
        info = f"Orden de {self.cliente.nombre} {self.cliente.apellido}\n"
        for item in self.items:
            info += item.mostrar_info() + "\n"
        info += f"Total: {self.total}"
        return info

class ItemOrden:
    def __init__(self, producto, cantidad):
        self.producto = producto
        self.cantidad = cantidad

    def calcular_subtotal(self):
        return self.producto.precio * self.cantidad

    def mostrar_info(self):
        return f"Item: {self.producto.nombre}, Cantidad: {self.cantidad}, Subtotal: {self.calcular_subtotal()}"

class Categoria:
    def __init__(self, nombre):
        self.nombre = nombre

    def mostrar_info(self):
        return f"Categoria: {self.nombre}"

class Tienda:
    def __init__(self):
        self.productos = []
        self.clientes = []
        self.ordenes = []
        self.categorias = []

    def registrar_producto(self, producto):
        self.productos.append(producto)

    def registrar_cliente(self, cliente):
        self.clientes.append(cliente)

    def crear_orden(self, cliente):
        orden = Orden(cliente)
        self.ordenes.append(orden)
        return orden

    def mostrar_productos(self):
        return [producto.mostrar_info() for producto in self.productos]

    def mostrar_clientes(self):
        return [cliente.mostrar_info() for cliente in self.clientes]

    def mostrar_ordenes(self):
        return [orden.mostrar_info() for orden in self.ordenes]

# Funciones de la interfaz
def agregar_producto():
    nombre = entry_nombre_producto.get()
    precio = float(entry_precio_producto.get())
    categoria_nombre = entry_categoria_producto.get()
    categoria = Categoria(categoria_nombre)
    producto = Producto(nombre, precio, categoria)
    tienda.registrar_producto(producto)
    actualizar_lista_productos()
    messagebox.showinfo("Información", "Producto agregado correctamente")

def mostrar_productos():
    productos_info = tienda.mostrar_productos()
    messagebox.showinfo("Productos", "\n".join(productos_info))

def agregar_cliente():
    nombre = entry_nombre_cliente.get()
    apellido = entry_apellido_cliente.get()
    id_cliente = entry_id_cliente.get()
    cliente = Cliente(nombre, apellido, id_cliente)
    tienda.registrar_cliente(cliente)
    actualizar_lista_clientes()
    messagebox.showinfo("Información", "Cliente agregado correctamente")

def mostrar_clientes():
    clientes_info = tienda.mostrar_clientes()
    messagebox.showinfo("Clientes", "\n".join(clientes_info))

def realizar_orden():
    id_cliente = entry_cliente_orden.get()
    nombre_producto = entry_producto_orden.get()
    cantidad = int(entry_cantidad_orden.get())

    cliente = next((c for c in tienda.clientes if c.id_cliente == id_cliente), None)
    producto = next((p for p in tienda.productos if p.nombre == nombre_producto), None)

    if cliente and producto:
        item_orden = ItemOrden(producto, cantidad)
        orden = tienda.crear_orden(cliente)
        orden.agregar_item(item_orden)
        actualizar_lista_ordenes()
        messagebox.showinfo("Información", "Orden realizada correctamente")
    else:
        messagebox.showerror("Error", "Cliente o producto no encontrado")

def mostrar_ordenes():
    ordenes_info = tienda.mostrar_ordenes()
    messagebox.showinfo("Órdenes", "\n".join(ordenes_info))

def cambiar_seccion(seccion):
    if seccion == "Salir":
        root.quit()  # Cierra la aplicación
        return
    
    for frame in frames.values():
        frame.pack_forget()
    frames[seccion].pack(fill="both", expand=True)

def actualizar_lista_productos():
    for widget in frame_lista_productos.winfo_children():
        widget.destroy()
    productos_info = tienda.mostrar_productos()
    for info in productos_info:
        label = tk.Label(frame_lista_productos, text=info, anchor="w", justify="left")
        label.pack(fill="x")

def actualizar_lista_clientes():
    for widget in frame_lista_clientes.winfo_children():
        widget.destroy()
    clientes_info = tienda.mostrar_clientes()
    for info in clientes_info:
        label = tk.Label(frame_lista_clientes, text=info, anchor="w", justify="left")
        label.pack(fill="x")

def actualizar_lista_ordenes():
    for widget in frame_lista_ordenes.winfo_children():
        widget.destroy()
    ordenes_info = tienda.mostrar_ordenes()
    for info in ordenes_info:
        label = tk.Label(frame_lista_ordenes, text=info, anchor="w", justify="left")
        label.pack(fill="x")

# Inicialización de la tienda
tienda = Tienda()

# Crear la ventana principal
root = tk.Tk()
root.title("Tienda de Componentes de Computadoras")

# Configurar la ventana principal para que ocupe toda la pantalla
root.geometry("1024x768")

# Crear el marco del menú
menu_frame = tk.Frame(root, bg="#2C3E50")
menu_frame.pack(side="left", fill="y")

# Crear el marco principal para el contenido
main_frame = tk.Frame(root)
main_frame.pack(side="right", fill="both", expand=True)

# Crear frames para cada sección
frames = {
    "Componentes": tk.Frame(main_frame),
    "Clientes": tk.Frame(main_frame),
    "Órdenes": tk.Frame(main_frame),
    "Registrar un componente": tk.Frame(main_frame),
    "Registrar un cliente": tk.Frame(main_frame),
    "Realizar una orden": tk.Frame(main_frame),
    "Salir": tk.Frame(main_frame)
}

# Agregar botones del menú
menu_buttons = [
    ("Componentes", "Componentes"),
    ("Clientes", "Clientes"),
    ("Órdenes", "Órdenes"),
    ("Registrar un componente", "Registrar un componente"),
    ("Registrar un cliente", "Registrar un cliente"),
    ("Realizar una orden", "Realizar una orden"),
    ("Salir", "Salir")
]

for text, seccion in menu_buttons:
    button = tk.Button(menu_frame, text=text, bg="#34495E", fg="white", command=lambda sec=seccion: cambiar_seccion(sec))
    button.pack(fill="x")

# Crear la interfaz de "Registrar un componente"
label_nombre_producto = tk.Label(frames["Registrar un componente"], text="Nombre del Componente")
label_nombre_producto.pack()

entry_nombre_producto = tk.Entry(frames["Registrar un componente"])
entry_nombre_producto.pack()

label_precio_producto = tk.Label(frames["Registrar un componente"], text="Precio del Componente")
label_precio_producto.pack()

entry_precio_producto = tk.Entry(frames["Registrar un componente"])
entry_precio_producto.pack()

label_categoria_producto = tk.Label(frames["Registrar un componente"], text="Categoría del Componente")
label_categoria_producto.pack()

entry_categoria_producto = tk.Entry(frames["Registrar un componente"])
entry_categoria_producto.pack()

button_agregar_producto = tk.Button(frames["Registrar un componente"], text="Agregar Componente", command=agregar_producto)
button_agregar_producto.pack()

# Crear la interfaz de "Componentes"
frame_lista_productos = tk.Frame(frames["Componentes"])
frame_lista_productos.pack(fill="both", expand=True)

# Crear la interfaz de "Registrar un cliente"
label_nombre_cliente = tk.Label(frames["Registrar un cliente"], text="Nombre del Cliente")
label_nombre_cliente.pack()

entry_nombre_cliente = tk.Entry(frames["Registrar un cliente"])
entry_nombre_cliente.pack()

label_apellido_cliente = tk.Label(frames["Registrar un cliente"], text="Apellido del Cliente")
label_apellido_cliente.pack()

entry_apellido_cliente = tk.Entry(frames["Registrar un cliente"])
entry_apellido_cliente.pack()

label_id_cliente = tk.Label(frames["Registrar un cliente"], text="ID del Cliente")
label_id_cliente.pack()

entry_id_cliente = tk.Entry(frames["Registrar un cliente"])
entry_id_cliente.pack()

button_agregar_cliente = tk.Button(frames["Registrar un cliente"], text="Agregar Cliente", command=agregar_cliente)
button_agregar_cliente.pack()

# Crear la interfaz de "Clientes"
frame_lista_clientes = tk.Frame(frames["Clientes"])
frame_lista_clientes.pack(fill="both", expand=True)

# Crear la interfaz de "Realizar una orden"
label_cliente_orden = tk.Label(frames["Realizar una orden"], text="ID del Cliente")
label_cliente_orden.pack()

entry_cliente_orden = tk.Entry(frames["Realizar una orden"])
entry_cliente_orden.pack()

label_producto_orden = tk.Label(frames["Realizar una orden"], text="Nombre del Producto")
label_producto_orden.pack()

entry_producto_orden = tk.Entry(frames["Realizar una orden"])
entry_producto_orden.pack()

label_cantidad_orden = tk.Label(frames["Realizar una orden"], text="Cantidad")
label_cantidad_orden.pack()

entry_cantidad_orden = tk.Entry(frames["Realizar una orden"])
entry_cantidad_orden.pack()

button_realizar_orden = tk.Button(frames["Realizar una orden"], text="Realizar Orden", command=realizar_orden)
button_realizar_orden.pack()

# Crear la interfaz de "Órdenes"
frame_lista_ordenes = tk.Frame(frames["Órdenes"])
frame_lista_ordenes.pack(fill="both", expand=True)

# Ejecutar el bucle principal de la aplicación
root.mainloop()
