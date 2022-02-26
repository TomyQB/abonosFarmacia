export interface AbonoOutput {
    id?: number,
    albaran?: string,
    codigo?: string,
    nombre?: string,
    fecha?: string,
    unidades?: number,
    archivo?: File
}

export interface AbonoFormData {
    id?: number,
    albaran: string,
    codigo: string,
    nombre: string,
    fecha: string,
    unidades: number,
    archivo: FormData
}