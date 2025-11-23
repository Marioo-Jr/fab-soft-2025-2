import { Condominio } from "./condominio";
import { Pessoa } from "./pessoa";

export class Imovel {

    id:number;
    numero:string;
    bloco:string;
    qtdeQuartos:number;
    qtdeBanheiros:number;
    vagaGaragem:number;
    statusImovel:string
    condominio:Condominio;
    nomeCondominio: string;
    nomeProprietario:string;
    proprietario: Pessoa;
}

// private Long id;
//     private String numero;
//     private String bloco;
//     private Integer qtdeQuartos;
//     private Integer qtdeBanheiros;
//     private Integer vagaGaragem;
//     private StatusImovel statusImovel;
//     private Long condominioId;
//     private Long proprietarioId;