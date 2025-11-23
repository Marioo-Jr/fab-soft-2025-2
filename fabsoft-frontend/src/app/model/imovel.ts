import { Condominio } from "./condominio";

export class Imovel {

    id:number;
    numero:string;
    bloco:string;
    qtdeQuartos:number;
    qtdeBanheiros:number;
    vagaGaragem:number;
    statusImovel:string
    condominio:Condominio;
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