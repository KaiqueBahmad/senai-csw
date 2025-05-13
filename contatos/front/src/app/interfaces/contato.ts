import { Grupo } from "../services/grupos-service.service";

export interface Contato {
    id?: number;
    nome?: string;
    email?: string;
    telefone?: string;
    favorito?: boolean;
    grupos?: Grupo[]
}
