export interface Abono {
    id?: number,
    albaran?: string,
    codigo?: string,
    nombre?: string,
    fecha?: Date,
    unidades?: number,
    archivo?: File
}

export interface AbonoFormData {
    id?: number,
    albaran: string,
    codigo: string,
    nombre: string,
    fecha: Date,
    unidades: number,
    archivo: FormData
}