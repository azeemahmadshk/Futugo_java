package org.shopify.integrator.beestore.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"IGUNegozio", "CodNegozio", "IGUArticolo", "Modello", "CodEsterno", "DSArticolo", "DSArticoloWeb", "Nota", "Um", "UmWeb", "CodIva", "Continuativo", "DayOne", "IGULinea", "DSLinea", "DSLineaWeb", "IGUStagione", "DSStagione", "DSStagioneWeb", "IGUTipoTaglia", "DSTipoTaglia", "DSTipoTagliaWeb", "IGUMarca", "DSMarca", "DSMarcaWeb", "IGUCampionario", "DSCampionario", "DSCampionarioWeb", "IGUMateriale", "DSMateriale", "DSMaterialeWeb", "IGUTipoEtichetta", "DSTipoEtichetta", "DSTipoEtichettaWeb", "IGUReparto", "DSReparto", "DSRepartoWeb", "IGUCategoriaMerceologica", "DSCategoriaMerceologica", "DSCategoriaMerceologicaWeb", "IGUSesso", "DSSesso", "DSSessoWeb", "CodArticolo", "BarCode", "CodColore", "IGUColore", "DSColore", "DSColoreWeb", "Indice", "Taglia", "IGUPrezzoVendita", "TipoPrezzo", "DataInizio", "DataFine", "IGUValuta", "PrezzoIvato", "Imponibile", "Sconto", "Aliquota", "Costo", "Annullato", "FlagEstrazioneTotale", "DTEstrazione", "PuntiPremio", "IGULingua", "CodLingua", "DSLingua", "DSArticoloAgg", "Classificazione1", "Classificazione2", "Classificazione3", "Classificazione4", "Classificazione5", "Classificazione6", "Classificazione7", "Classificazione8", "Classificazione9", "Classificazione10", "DSAttributoMultiplo1", "DSAttributoMultiplo2", "IDArticolo", "IDLinea", "IDStagione", "IDTipoTaglia", "IDMarca", "IDCampionario", "IDMateriale", "IDTipoEtichetta", "IDCategoriaMerceologica", "IDSesso", "IDArtCod", "IDColore", "IDTaglia", "Peso", "URLImg1", "URLImg2", "URLImg3", "URLImg4", "URLImg5", "Disponibilita", "PrezzoImponibileNetto", "ArticoloDescrizionePers", "RetailItalyNetto", "FlagTipoArticolo", "CodAlternativo", "FlagScontabile", "DSArticoloAggWeb", "DescrClass1", "DescrClass1Web", "DescrClass2", "DescrClass2Web", "DescrClass3", "DescrClass3Web", "Classificazione", "PrezzoScontatoIvato", "ScontoListino", "PrezzoScontatoNetto", "RaggruppamentoLinea", "IDReparto", "CostoImponibileNetto", "BarcodeCustom", "SKUCustom", "URLImg6", "URLImg7", "URLImg8", "URLImg9", "URLImg10", "EAN", "ModelloOwner"})
public class BeeStoreFtpProduct {


    @JsonProperty("IGUNegozio")
    String IGUNegozio;

    @JsonProperty("CodNegozio")
    String CodNegozio;

    @JsonProperty("IGUArticolo")
    String IGUArticolo;

    @JsonProperty("Modello")
    String Modello;

    @JsonProperty("CodEsterno")
    String CodEsterno;

    @JsonProperty("DSArticolo")
    String DSArticolo;

    @JsonProperty("DSArticoloWeb")
    String DSArticoloWeb;

    @JsonProperty("Nota")
    String Nota;

    @JsonProperty("Um")
    String Um;

    @JsonProperty("UmWeb")
    String UmWeb;

    @JsonProperty("CodIva")
    String CodIva;

    @JsonProperty("Continuativo")
    String Continuativo;

    @JsonProperty("DayOne")
    String DayOne;

    @JsonProperty("IGULinea")
    String IGULinea;

    @JsonProperty("DSLinea")
    String DSLinea;

    @JsonProperty("DSLineaWeb")
    String DSLineaWeb;

    @JsonProperty("IGUStagione")
    String IGUStagione;

    @JsonProperty("DSStagione")
    String DSStagione;

    @JsonProperty("DSStagioneWeb")
    String DSStagioneWeb;

    @JsonProperty("IGUTipoTaglia")
    String IGUTipoTaglia;

    @JsonProperty("DSTipoTaglia")
    String DSTipoTaglia;

    @JsonProperty("DSTipoTagliaWeb")
    String DSTipoTagliaWeb;

    @JsonProperty("IGUMarca")
    String IGUMarca;

    @JsonProperty("DSMarca")
    String DSMarca;

    @JsonProperty("DSMarcaWeb")
    String DSMarcaWeb;

    @JsonProperty("IGUCampionario")
    String IGUCampionario;

    @JsonProperty("DSCampionario")
    String DSCampionario;

    @JsonProperty("DSCampionarioWeb")
    String DSCampionarioWeb;

    @JsonProperty("IGUMateriale")
    String IGUMateriale;

    @JsonProperty("DSMateriale")
    String DSMateriale;

    @JsonProperty("DSMaterialeWeb")
    String DSMaterialeWeb;

    @JsonProperty("IGUTipoEtichetta")
    String IGUTipoEtichetta;

    @JsonProperty("DSTipoEtichetta")
    String DSTipoEtichetta;

    @JsonProperty("DSTipoEtichettaWeb")
    String DSTipoEtichettaWeb;

    @JsonProperty("IGUReparto")
    String IGUReparto;

    @JsonProperty("DSReparto")
    String DSReparto;

    @JsonProperty("DSRepartoWeb")
    String DSRepartoWeb;

    @JsonProperty("IGUCategoriaMerceologica")
    String IGUCategoriaMerceologica;

    @JsonProperty("DSCategoriaMerceologica")
    String DSCategoriaMerceologica;

    @JsonProperty("DSCategoriaMerceologicaWeb")
    String DSCategoriaMerceologicaWeb;

    @JsonProperty("IGUSesso")
    String IGUSesso;

    @JsonProperty("DSSesso")
    String DSSesso;

    @JsonProperty("DSSessoWeb")
    String DSSessoWeb;

    @JsonProperty("CodArticolo")
    String CodArticolo;

    @JsonProperty("BarCode")
    String BarCode;

    @JsonProperty("CodColore")
    String CodColore;

    @JsonProperty("IGUColore")
    String IGUColore;

    @JsonProperty("DSColore")
    String DSColore;

    @JsonProperty("DSColoreWeb")
    String DSColoreWeb;

    @JsonProperty("Indice")
    String Indice;

    @JsonProperty("Taglia")
    String Taglia;

    @JsonProperty("IGUPrezzoVendita")
    String IGUPrezzoVendita;

    @JsonProperty("TipoPrezzo")
    String TipoPrezzo;

    @JsonProperty("DataInizio")
    String DataInizio;

    @JsonProperty("DataFine")
    String DataFine;

    @JsonProperty("IGUValuta")
    String IGUValuta;

    @JsonProperty("PrezzoIvato")
    String PrezzoIvato;

    @JsonProperty("Imponibile")
    String Imponibile;

    @JsonProperty("Sconto")
    String Sconto;

    @JsonProperty("Aliquota")
    String Aliquota;

    @JsonProperty("Costo")
    String Costo;

    @JsonProperty("Annullato")
    String Annullato;

    @JsonProperty("FlagEstrazioneTotale")
    String FlagEstrazioneTotale;

    @JsonProperty("DTEstrazione")
    String DTEstrazione;

    @JsonProperty("PuntiPremio")
    String PuntiPremio;

    @JsonProperty("IGULingua")
    String IGULingua;

    @JsonProperty("CodLingua")
    String CodLingua;

    @JsonProperty("DSLingua")
    String DSLingua;

    @JsonProperty("DSArticoloAgg")
    String DSArticoloAgg;

    @JsonProperty("Classificazione1")
    String Classificazione1;

    @JsonProperty("Classificazione2")
    String Classificazione2;

    @JsonProperty("Classificazione3")
    String Classificazione3;

    @JsonProperty("Classificazione4")
    String Classificazione4;

    @JsonProperty("Classificazione5")
    String Classificazione5;

    @JsonProperty("Classificazione6")
    String Classificazione6;

    @JsonProperty("Classificazione7")
    String Classificazione7;

    @JsonProperty("Classificazione8")
    String Classificazione8;

    @JsonProperty("Classificazione9")
    String Classificazione9;

    @JsonProperty("Classificazione10")
    String Classificazione10;

    @JsonProperty("DSAttributoMultiplo1")
    String DSAttributoMultiplo1;

    @JsonProperty("DSAttributoMultiplo2")
    String DSAttributoMultiplo2;

    @JsonProperty("IDArticolo")
    String IDArticolo;

    @JsonProperty("IDLinea")
    String IDLinea;

    @JsonProperty("IDStagione")
    String IDStagione;

    @JsonProperty("IDTipoTaglia")
    String IDTipoTaglia;

    @JsonProperty("IDMarca")
    String IDMarca;

    @JsonProperty("IDCampionario")
    String IDCampionario;

    @JsonProperty("IDMateriale")
    String IDMateriale;

    @JsonProperty("IDTipoEtichetta")
    String IDTipoEtichetta;

    @JsonProperty("IDCategoriaMerceologica")
    String IDCategoriaMerceologica;

    @JsonProperty("IDSesso")
    String IDSesso;

    @JsonProperty("IDArtCod")
    String IDArtCod;

    @JsonProperty("IDColore")
    String IDColore;

    @JsonProperty("IDTaglia")
    String IDTaglia;

    @JsonProperty("Peso")
    String Peso;

    @JsonProperty("URLImg1")
    String URLImg1;

    @JsonProperty("URLImg2")
    String URLImg2;

    @JsonProperty("URLImg3")
    String URLImg3;

    @JsonProperty("URLImg4")
    String URLImg4;

    @JsonProperty("URLImg5")
    String URLImg5;

    @JsonProperty("Disponibilita")
    String Disponibilita;

    @JsonProperty("PrezzoImponibileNetto")
    String PrezzoImponibileNetto;

    @JsonProperty("ArticoloDescrizionePers")
    String ArticoloDescrizionePers;

    @JsonProperty("RetailItalyNetto")
    String RetailItalyNetto;

    @JsonProperty("FlagTipoArticolo")
    String FlagTipoArticolo;

    @JsonProperty("CodAlternativo")
    String CodAlternativo;

    @JsonProperty("FlagScontabile")
    String FlagScontabile;

    @JsonProperty("DSArticoloAggWeb")
    String DSArticoloAggWeb;

    @JsonProperty("DescrClass1")
    String DescrClass1;

    @JsonProperty("DescrClass1Web")
    String DescrClass1Web;

    @JsonProperty("DescrClass2")
    String DescrClass2;

    @JsonProperty("DescrClass2Web")
    String DescrClass2Web;

    @JsonProperty("DescrClass3")
    String DescrClass3;

    @JsonProperty("DescrClass3Web")
    String DescrClass3Web;

    @JsonProperty("Classificazione")
    String Classificazione;

    @JsonProperty("PrezzoScontatoIvato")
    String PrezzoScontatoIvato;

    @JsonProperty("ScontoListino")
    String ScontoListino;

    @JsonProperty("PrezzoScontatoNetto")
    String PrezzoScontatoNetto;

    @JsonProperty("RaggruppamentoLinea")
    String RaggruppamentoLinea;

    @JsonProperty("IDReparto")
    String IDReparto;

    @JsonProperty("CostoImponibileNetto")
    String CostoImponibileNetto;

    @JsonProperty("BarcodeCustom")
    String BarcodeCustom;

    @JsonProperty("SKUCustom")
    String SKUCustom;

    @JsonProperty("URLImg6")
    String URLImg6;

    @JsonProperty("URLImg7")
    String URLImg7;

    @JsonProperty("URLImg8")
    String URLImg8;

    @JsonProperty("URLImg9")
    String URLImg9;

    @JsonProperty("URLImg10")
    String URLImg10;

    @JsonProperty("EAN")
    String EAN;

    @JsonProperty("ModelloOwner")
    String ModelloOwner;

    public String getIGUNegozio() {
        return IGUNegozio;
    }

    public void setIGUNegozio(String IGUNegozio) {
        this.IGUNegozio = IGUNegozio;
    }

    public String getCodNegozio() {
        return CodNegozio;
    }

    public void setCodNegozio(String codNegozio) {
        CodNegozio = codNegozio;
    }

    public String getIGUArticolo() {
        return IGUArticolo;
    }

    public void setIGUArticolo(String IGUArticolo) {
        this.IGUArticolo = IGUArticolo;
    }

    public String getModello() {
        return Modello;
    }

    public void setModello(String modello) {
        Modello = modello;
    }

    public String getCodEsterno() {
        return CodEsterno;
    }

    public void setCodEsterno(String codEsterno) {
        CodEsterno = codEsterno;
    }

    public String getDSArticolo() {
        return DSArticolo;
    }

    public void setDSArticolo(String DSArticolo) {
        this.DSArticolo = DSArticolo;
    }

    public String getDSArticoloWeb() {
        return DSArticoloWeb;
    }

    public void setDSArticoloWeb(String DSArticoloWeb) {
        this.DSArticoloWeb = DSArticoloWeb;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String nota) {
        Nota = nota;
    }

    public String getUm() {
        return Um;
    }

    public void setUm(String um) {
        Um = um;
    }

    public String getUmWeb() {
        return UmWeb;
    }

    public void setUmWeb(String umWeb) {
        UmWeb = umWeb;
    }

    public String getCodIva() {
        return CodIva;
    }

    public void setCodIva(String codIva) {
        CodIva = codIva;
    }

    public String getContinuativo() {
        return Continuativo;
    }

    public void setContinuativo(String continuativo) {
        Continuativo = continuativo;
    }

    public String getDayOne() {
        return DayOne;
    }

    public void setDayOne(String dayOne) {
        DayOne = dayOne;
    }

    public String getIGULinea() {
        return IGULinea;
    }

    public void setIGULinea(String IGULinea) {
        this.IGULinea = IGULinea;
    }

    public String getDSLinea() {
        return DSLinea;
    }

    public void setDSLinea(String DSLinea) {
        this.DSLinea = DSLinea;
    }

    public String getDSLineaWeb() {
        return DSLineaWeb;
    }

    public void setDSLineaWeb(String DSLineaWeb) {
        this.DSLineaWeb = DSLineaWeb;
    }

    public String getIGUStagione() {
        return IGUStagione;
    }

    public void setIGUStagione(String IGUStagione) {
        this.IGUStagione = IGUStagione;
    }

    public String getDSStagione() {
        return DSStagione;
    }

    public void setDSStagione(String DSStagione) {
        this.DSStagione = DSStagione;
    }

    public String getDSStagioneWeb() {
        return DSStagioneWeb;
    }

    public void setDSStagioneWeb(String DSStagioneWeb) {
        this.DSStagioneWeb = DSStagioneWeb;
    }

    public String getIGUTipoTaglia() {
        return IGUTipoTaglia;
    }

    public void setIGUTipoTaglia(String IGUTipoTaglia) {
        this.IGUTipoTaglia = IGUTipoTaglia;
    }

    public String getDSTipoTaglia() {
        return DSTipoTaglia;
    }

    public void setDSTipoTaglia(String DSTipoTaglia) {
        this.DSTipoTaglia = DSTipoTaglia;
    }

    public String getDSTipoTagliaWeb() {
        return DSTipoTagliaWeb;
    }

    public void setDSTipoTagliaWeb(String DSTipoTagliaWeb) {
        this.DSTipoTagliaWeb = DSTipoTagliaWeb;
    }

    public String getIGUMarca() {
        return IGUMarca;
    }

    public void setIGUMarca(String IGUMarca) {
        this.IGUMarca = IGUMarca;
    }

    public String getDSMarca() {
        return DSMarca;
    }

    public void setDSMarca(String DSMarca) {
        this.DSMarca = DSMarca;
    }

    public String getDSMarcaWeb() {
        return DSMarcaWeb;
    }

    public void setDSMarcaWeb(String DSMarcaWeb) {
        this.DSMarcaWeb = DSMarcaWeb;
    }

    public String getIGUCampionario() {
        return IGUCampionario;
    }

    public void setIGUCampionario(String IGUCampionario) {
        this.IGUCampionario = IGUCampionario;
    }

    public String getDSCampionario() {
        return DSCampionario;
    }

    public void setDSCampionario(String DSCampionario) {
        this.DSCampionario = DSCampionario;
    }

    public String getDSCampionarioWeb() {
        return DSCampionarioWeb;
    }

    public void setDSCampionarioWeb(String DSCampionarioWeb) {
        this.DSCampionarioWeb = DSCampionarioWeb;
    }

    public String getIGUMateriale() {
        return IGUMateriale;
    }

    public void setIGUMateriale(String IGUMateriale) {
        this.IGUMateriale = IGUMateriale;
    }

    public String getDSMateriale() {
        return DSMateriale;
    }

    public void setDSMateriale(String DSMateriale) {
        this.DSMateriale = DSMateriale;
    }

    public String getDSMaterialeWeb() {
        return DSMaterialeWeb;
    }

    public void setDSMaterialeWeb(String DSMaterialeWeb) {
        this.DSMaterialeWeb = DSMaterialeWeb;
    }

    public String getIGUTipoEtichetta() {
        return IGUTipoEtichetta;
    }

    public void setIGUTipoEtichetta(String IGUTipoEtichetta) {
        this.IGUTipoEtichetta = IGUTipoEtichetta;
    }

    public String getDSTipoEtichetta() {
        return DSTipoEtichetta;
    }

    public void setDSTipoEtichetta(String DSTipoEtichetta) {
        this.DSTipoEtichetta = DSTipoEtichetta;
    }

    public String getDSTipoEtichettaWeb() {
        return DSTipoEtichettaWeb;
    }

    public void setDSTipoEtichettaWeb(String DSTipoEtichettaWeb) {
        this.DSTipoEtichettaWeb = DSTipoEtichettaWeb;
    }

    public String getIGUReparto() {
        return IGUReparto;
    }

    public void setIGUReparto(String IGUReparto) {
        this.IGUReparto = IGUReparto;
    }

    public String getDSReparto() {
        return DSReparto;
    }

    public void setDSReparto(String DSReparto) {
        this.DSReparto = DSReparto;
    }

    public String getDSRepartoWeb() {
        return DSRepartoWeb;
    }

    public void setDSRepartoWeb(String DSRepartoWeb) {
        this.DSRepartoWeb = DSRepartoWeb;
    }

    public String getIGUCategoriaMerceologica() {
        return IGUCategoriaMerceologica;
    }

    public void setIGUCategoriaMerceologica(String IGUCategoriaMerceologica) {
        this.IGUCategoriaMerceologica = IGUCategoriaMerceologica;
    }

    public String getDSCategoriaMerceologica() {
        return DSCategoriaMerceologica;
    }

    public void setDSCategoriaMerceologica(String DSCategoriaMerceologica) {
        this.DSCategoriaMerceologica = DSCategoriaMerceologica;
    }

    public String getDSCategoriaMerceologicaWeb() {
        return DSCategoriaMerceologicaWeb;
    }

    public void setDSCategoriaMerceologicaWeb(String DSCategoriaMerceologicaWeb) {
        this.DSCategoriaMerceologicaWeb = DSCategoriaMerceologicaWeb;
    }

    public String getIGUSesso() {
        return IGUSesso;
    }

    public void setIGUSesso(String IGUSesso) {
        this.IGUSesso = IGUSesso;
    }

    public String getDSSesso() {
        return DSSesso;
    }

    public void setDSSesso(String DSSesso) {
        this.DSSesso = DSSesso;
    }

    public String getDSSessoWeb() {
        return DSSessoWeb;
    }

    public void setDSSessoWeb(String DSSessoWeb) {
        this.DSSessoWeb = DSSessoWeb;
    }

    public String getCodArticolo() {
        return CodArticolo;
    }

    public void setCodArticolo(String codArticolo) {
        CodArticolo = codArticolo;
    }

    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }

    public String getCodColore() {
        return CodColore;
    }

    public void setCodColore(String codColore) {
        CodColore = codColore;
    }

    public String getIGUColore() {
        return IGUColore;
    }

    public void setIGUColore(String IGUColore) {
        this.IGUColore = IGUColore;
    }

    public String getDSColore() {
        return DSColore;
    }

    public void setDSColore(String DSColore) {
        this.DSColore = DSColore;
    }

    public String getDSColoreWeb() {
        return DSColoreWeb;
    }

    public void setDSColoreWeb(String DSColoreWeb) {
        this.DSColoreWeb = DSColoreWeb;
    }

    public String getIndice() {
        return Indice;
    }

    public void setIndice(String indice) {
        Indice = indice;
    }

    public String getTaglia() {
        return Taglia;
    }

    public void setTaglia(String taglia) {
        Taglia = taglia;
    }

    public String getIGUPrezzoVendita() {
        return IGUPrezzoVendita;
    }

    public void setIGUPrezzoVendita(String IGUPrezzoVendita) {
        this.IGUPrezzoVendita = IGUPrezzoVendita;
    }

    public String getTipoPrezzo() {
        return TipoPrezzo;
    }

    public void setTipoPrezzo(String tipoPrezzo) {
        TipoPrezzo = tipoPrezzo;
    }

    public String getDataInizio() {
        return DataInizio;
    }

    public void setDataInizio(String dataInizio) {
        DataInizio = dataInizio;
    }

    public String getDataFine() {
        return DataFine;
    }

    public void setDataFine(String dataFine) {
        DataFine = dataFine;
    }

    public String getIGUValuta() {
        return IGUValuta;
    }

    public void setIGUValuta(String IGUValuta) {
        this.IGUValuta = IGUValuta;
    }

    public String getPrezzoIvato() {
        return PrezzoIvato;
    }

    public void setPrezzoIvato(String prezzoIvato) {
        PrezzoIvato = prezzoIvato;
    }

    public String getImponibile() {
        return Imponibile;
    }

    public void setImponibile(String imponibile) {
        Imponibile = imponibile;
    }

    public String getSconto() {
        return Sconto;
    }

    public void setSconto(String sconto) {
        Sconto = sconto;
    }

    public String getAliquota() {
        return Aliquota;
    }

    public void setAliquota(String aliquota) {
        Aliquota = aliquota;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String costo) {
        Costo = costo;
    }

    public String getAnnullato() {
        return Annullato;
    }

    public void setAnnullato(String annullato) {
        Annullato = annullato;
    }

    public String getFlagEstrazioneTotale() {
        return FlagEstrazioneTotale;
    }

    public void setFlagEstrazioneTotale(String flagEstrazioneTotale) {
        FlagEstrazioneTotale = flagEstrazioneTotale;
    }

    public String getDTEstrazione() {
        return DTEstrazione;
    }

    public void setDTEstrazione(String DTEstrazione) {
        this.DTEstrazione = DTEstrazione;
    }

    public String getPuntiPremio() {
        return PuntiPremio;
    }

    public void setPuntiPremio(String puntiPremio) {
        PuntiPremio = puntiPremio;
    }

    public String getIGULingua() {
        return IGULingua;
    }

    public void setIGULingua(String IGULingua) {
        this.IGULingua = IGULingua;
    }

    public String getCodLingua() {
        return CodLingua;
    }

    public void setCodLingua(String codLingua) {
        CodLingua = codLingua;
    }

    public String getDSLingua() {
        return DSLingua;
    }

    public void setDSLingua(String DSLingua) {
        this.DSLingua = DSLingua;
    }

    public String getDSArticoloAgg() {
        return DSArticoloAgg;
    }

    public void setDSArticoloAgg(String DSArticoloAgg) {
        this.DSArticoloAgg = DSArticoloAgg;
    }

    public String getClassificazione1() {
        return Classificazione1;
    }

    public void setClassificazione1(String classificazione1) {
        Classificazione1 = classificazione1;
    }

    public String getClassificazione2() {
        return Classificazione2;
    }

    public void setClassificazione2(String classificazione2) {
        Classificazione2 = classificazione2;
    }

    public String getClassificazione3() {
        return Classificazione3;
    }

    public void setClassificazione3(String classificazione3) {
        Classificazione3 = classificazione3;
    }

    public String getClassificazione4() {
        return Classificazione4;
    }

    public void setClassificazione4(String classificazione4) {
        Classificazione4 = classificazione4;
    }

    public String getClassificazione5() {
        return Classificazione5;
    }

    public void setClassificazione5(String classificazione5) {
        Classificazione5 = classificazione5;
    }

    public String getClassificazione6() {
        return Classificazione6;
    }

    public void setClassificazione6(String classificazione6) {
        Classificazione6 = classificazione6;
    }

    public String getClassificazione7() {
        return Classificazione7;
    }

    public void setClassificazione7(String classificazione7) {
        Classificazione7 = classificazione7;
    }

    public String getClassificazione8() {
        return Classificazione8;
    }

    public void setClassificazione8(String classificazione8) {
        Classificazione8 = classificazione8;
    }

    public String getClassificazione9() {
        return Classificazione9;
    }

    public void setClassificazione9(String classificazione9) {
        Classificazione9 = classificazione9;
    }

    public String getClassificazione10() {
        return Classificazione10;
    }

    public void setClassificazione10(String classificazione10) {
        Classificazione10 = classificazione10;
    }

    public String getDSAttributoMultiplo1() {
        return DSAttributoMultiplo1;
    }

    public void setDSAttributoMultiplo1(String DSAttributoMultiplo1) {
        this.DSAttributoMultiplo1 = DSAttributoMultiplo1;
    }

    public String getDSAttributoMultiplo2() {
        return DSAttributoMultiplo2;
    }

    public void setDSAttributoMultiplo2(String DSAttributoMultiplo2) {
        this.DSAttributoMultiplo2 = DSAttributoMultiplo2;
    }

    public String getIDArticolo() {
        return IDArticolo;
    }

    public void setIDArticolo(String IDArticolo) {
        this.IDArticolo = IDArticolo;
    }

    public String getIDLinea() {
        return IDLinea;
    }

    public void setIDLinea(String IDLinea) {
        this.IDLinea = IDLinea;
    }

    public String getIDStagione() {
        return IDStagione;
    }

    public void setIDStagione(String IDStagione) {
        this.IDStagione = IDStagione;
    }

    public String getIDTipoTaglia() {
        return IDTipoTaglia;
    }

    public void setIDTipoTaglia(String IDTipoTaglia) {
        this.IDTipoTaglia = IDTipoTaglia;
    }

    public String getIDMarca() {
        return IDMarca;
    }

    public void setIDMarca(String IDMarca) {
        this.IDMarca = IDMarca;
    }

    public String getIDCampionario() {
        return IDCampionario;
    }

    public void setIDCampionario(String IDCampionario) {
        this.IDCampionario = IDCampionario;
    }

    public String getIDMateriale() {
        return IDMateriale;
    }

    public void setIDMateriale(String IDMateriale) {
        this.IDMateriale = IDMateriale;
    }

    public String getIDTipoEtichetta() {
        return IDTipoEtichetta;
    }

    public void setIDTipoEtichetta(String IDTipoEtichetta) {
        this.IDTipoEtichetta = IDTipoEtichetta;
    }

    public String getIDCategoriaMerceologica() {
        return IDCategoriaMerceologica;
    }

    public void setIDCategoriaMerceologica(String IDCategoriaMerceologica) {
        this.IDCategoriaMerceologica = IDCategoriaMerceologica;
    }

    public String getIDSesso() {
        return IDSesso;
    }

    public void setIDSesso(String IDSesso) {
        this.IDSesso = IDSesso;
    }

    public String getIDArtCod() {
        return IDArtCod;
    }

    public void setIDArtCod(String IDArtCod) {
        this.IDArtCod = IDArtCod;
    }

    public String getIDColore() {
        return IDColore;
    }

    public void setIDColore(String IDColore) {
        this.IDColore = IDColore;
    }

    public String getIDTaglia() {
        return IDTaglia;
    }

    public void setIDTaglia(String IDTaglia) {
        this.IDTaglia = IDTaglia;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getURLImg1() {
        return URLImg1;
    }

    public void setURLImg1(String URLImg1) {
        this.URLImg1 = URLImg1;
    }

    public String getURLImg2() {
        return URLImg2;
    }

    public void setURLImg2(String URLImg2) {
        this.URLImg2 = URLImg2;
    }

    public String getURLImg3() {
        return URLImg3;
    }

    public void setURLImg3(String URLImg3) {
        this.URLImg3 = URLImg3;
    }

    public String getURLImg4() {
        return URLImg4;
    }

    public void setURLImg4(String URLImg4) {
        this.URLImg4 = URLImg4;
    }

    public String getURLImg5() {
        return URLImg5;
    }

    public void setURLImg5(String URLImg5) {
        this.URLImg5 = URLImg5;
    }

    public String getDisponibilita() {
        return Disponibilita;
    }

    public void setDisponibilita(String disponibilita) {
        Disponibilita = disponibilita;
    }

    public String getPrezzoImponibileNetto() {
        return PrezzoImponibileNetto;
    }

    public void setPrezzoImponibileNetto(String prezzoImponibileNetto) {
        PrezzoImponibileNetto = prezzoImponibileNetto;
    }

    public String getArticoloDescrizionePers() {
        return ArticoloDescrizionePers;
    }

    public void setArticoloDescrizionePers(String articoloDescrizionePers) {
        ArticoloDescrizionePers = articoloDescrizionePers;
    }

    public String getRetailItalyNetto() {
        return RetailItalyNetto;
    }

    public void setRetailItalyNetto(String retailItalyNetto) {
        RetailItalyNetto = retailItalyNetto;
    }

    public String getFlagTipoArticolo() {
        return FlagTipoArticolo;
    }

    public void setFlagTipoArticolo(String flagTipoArticolo) {
        FlagTipoArticolo = flagTipoArticolo;
    }

    public String getCodAlternativo() {
        return CodAlternativo;
    }

    public void setCodAlternativo(String codAlternativo) {
        CodAlternativo = codAlternativo;
    }

    public String getFlagScontabile() {
        return FlagScontabile;
    }

    public void setFlagScontabile(String flagScontabile) {
        FlagScontabile = flagScontabile;
    }

    public String getDSArticoloAggWeb() {
        return DSArticoloAggWeb;
    }

    public void setDSArticoloAggWeb(String DSArticoloAggWeb) {
        this.DSArticoloAggWeb = DSArticoloAggWeb;
    }

    public String getDescrClass1() {
        return DescrClass1;
    }

    public void setDescrClass1(String descrClass1) {
        DescrClass1 = descrClass1;
    }

    public String getDescrClass1Web() {
        return DescrClass1Web;
    }

    public void setDescrClass1Web(String descrClass1Web) {
        DescrClass1Web = descrClass1Web;
    }

    public String getDescrClass2() {
        return DescrClass2;
    }

    public void setDescrClass2(String descrClass2) {
        DescrClass2 = descrClass2;
    }

    public String getDescrClass2Web() {
        return DescrClass2Web;
    }

    public void setDescrClass2Web(String descrClass2Web) {
        DescrClass2Web = descrClass2Web;
    }

    public String getDescrClass3() {
        return DescrClass3;
    }

    public void setDescrClass3(String descrClass3) {
        DescrClass3 = descrClass3;
    }

    public String getDescrClass3Web() {
        return DescrClass3Web;
    }

    public void setDescrClass3Web(String descrClass3Web) {
        DescrClass3Web = descrClass3Web;
    }

    public String getClassificazione() {
        return Classificazione;
    }

    public void setClassificazione(String classificazione) {
        Classificazione = classificazione;
    }

    public String getPrezzoScontatoIvato() {
        return PrezzoScontatoIvato;
    }

    public void setPrezzoScontatoIvato(String prezzoScontatoIvato) {
        PrezzoScontatoIvato = prezzoScontatoIvato;
    }

    public String getScontoListino() {
        return ScontoListino;
    }

    public void setScontoListino(String scontoListino) {
        ScontoListino = scontoListino;
    }

    public String getPrezzoScontatoNetto() {
        return PrezzoScontatoNetto;
    }

    public void setPrezzoScontatoNetto(String prezzoScontatoNetto) {
        PrezzoScontatoNetto = prezzoScontatoNetto;
    }

    public String getRaggruppamentoLinea() {
        return RaggruppamentoLinea;
    }

    public void setRaggruppamentoLinea(String raggruppamentoLinea) {
        RaggruppamentoLinea = raggruppamentoLinea;
    }

    public String getIDReparto() {
        return IDReparto;
    }

    public void setIDReparto(String IDReparto) {
        this.IDReparto = IDReparto;
    }

    public String getCostoImponibileNetto() {
        return CostoImponibileNetto;
    }

    public void setCostoImponibileNetto(String costoImponibileNetto) {
        CostoImponibileNetto = costoImponibileNetto;
    }

    public String getBarcodeCustom() {
        return BarcodeCustom;
    }

    public void setBarcodeCustom(String barcodeCustom) {
        BarcodeCustom = barcodeCustom;
    }

    public String getSKUCustom() {
        return SKUCustom;
    }

    public void setSKUCustom(String SKUCustom) {
        this.SKUCustom = SKUCustom;
    }

    public String getURLImg6() {
        return URLImg6;
    }

    public void setURLImg6(String URLImg6) {
        this.URLImg6 = URLImg6;
    }

    public String getURLImg7() {
        return URLImg7;
    }

    public void setURLImg7(String URLImg7) {
        this.URLImg7 = URLImg7;
    }

    public String getURLImg8() {
        return URLImg8;
    }

    public void setURLImg8(String URLImg8) {
        this.URLImg8 = URLImg8;
    }

    public String getURLImg9() {
        return URLImg9;
    }

    public void setURLImg9(String URLImg9) {
        this.URLImg9 = URLImg9;
    }

    public String getURLImg10() {
        return URLImg10;
    }

    public void setURLImg10(String URLImg10) {
        this.URLImg10 = URLImg10;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public String getModelloOwner() {
        return ModelloOwner;
    }

    public void setModelloOwner(String modelloOwner) {
        ModelloOwner = modelloOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeeStoreFtpProduct that = (BeeStoreFtpProduct) o;
        return Objects.equals(IGUNegozio, that.IGUNegozio) && Objects.equals(CodNegozio, that.CodNegozio) && Objects.equals(IGUArticolo, that.IGUArticolo) && Objects.equals(Modello, that.Modello) && Objects.equals(CodEsterno, that.CodEsterno) && Objects.equals(DSArticolo, that.DSArticolo) && Objects.equals(DSArticoloWeb, that.DSArticoloWeb) && Objects.equals(Nota, that.Nota) && Objects.equals(Um, that.Um) && Objects.equals(UmWeb, that.UmWeb) && Objects.equals(CodIva, that.CodIva) && Objects.equals(Continuativo, that.Continuativo) && Objects.equals(DayOne, that.DayOne) && Objects.equals(IGULinea, that.IGULinea) && Objects.equals(DSLinea, that.DSLinea) && Objects.equals(DSLineaWeb, that.DSLineaWeb) && Objects.equals(IGUStagione, that.IGUStagione) && Objects.equals(DSStagione, that.DSStagione) && Objects.equals(DSStagioneWeb, that.DSStagioneWeb) && Objects.equals(IGUTipoTaglia, that.IGUTipoTaglia) && Objects.equals(DSTipoTaglia, that.DSTipoTaglia) && Objects.equals(DSTipoTagliaWeb, that.DSTipoTagliaWeb) && Objects.equals(IGUMarca, that.IGUMarca) && Objects.equals(DSMarca, that.DSMarca) && Objects.equals(DSMarcaWeb, that.DSMarcaWeb) && Objects.equals(IGUCampionario, that.IGUCampionario) && Objects.equals(DSCampionario, that.DSCampionario) && Objects.equals(DSCampionarioWeb, that.DSCampionarioWeb) && Objects.equals(IGUMateriale, that.IGUMateriale) && Objects.equals(DSMateriale, that.DSMateriale) && Objects.equals(DSMaterialeWeb, that.DSMaterialeWeb) && Objects.equals(IGUTipoEtichetta, that.IGUTipoEtichetta) && Objects.equals(DSTipoEtichetta, that.DSTipoEtichetta) && Objects.equals(DSTipoEtichettaWeb, that.DSTipoEtichettaWeb) && Objects.equals(IGUReparto, that.IGUReparto) && Objects.equals(DSReparto, that.DSReparto) && Objects.equals(DSRepartoWeb, that.DSRepartoWeb) && Objects.equals(IGUCategoriaMerceologica, that.IGUCategoriaMerceologica) && Objects.equals(DSCategoriaMerceologica, that.DSCategoriaMerceologica) && Objects.equals(DSCategoriaMerceologicaWeb, that.DSCategoriaMerceologicaWeb) && Objects.equals(IGUSesso, that.IGUSesso) && Objects.equals(DSSesso, that.DSSesso) && Objects.equals(DSSessoWeb, that.DSSessoWeb) && Objects.equals(CodArticolo, that.CodArticolo) && Objects.equals(BarCode, that.BarCode) && Objects.equals(CodColore, that.CodColore) && Objects.equals(IGUColore, that.IGUColore) && Objects.equals(DSColore, that.DSColore) && Objects.equals(DSColoreWeb, that.DSColoreWeb) && Objects.equals(Indice, that.Indice) && Objects.equals(Taglia, that.Taglia) && Objects.equals(IGUPrezzoVendita, that.IGUPrezzoVendita) && Objects.equals(TipoPrezzo, that.TipoPrezzo) && Objects.equals(DataInizio, that.DataInizio) && Objects.equals(DataFine, that.DataFine) && Objects.equals(IGUValuta, that.IGUValuta) && Objects.equals(PrezzoIvato, that.PrezzoIvato) && Objects.equals(Imponibile, that.Imponibile) && Objects.equals(Sconto, that.Sconto) && Objects.equals(Aliquota, that.Aliquota) && Objects.equals(Costo, that.Costo) && Objects.equals(Annullato, that.Annullato) && Objects.equals(FlagEstrazioneTotale, that.FlagEstrazioneTotale) && Objects.equals(DTEstrazione, that.DTEstrazione) && Objects.equals(PuntiPremio, that.PuntiPremio) && Objects.equals(IGULingua, that.IGULingua) && Objects.equals(CodLingua, that.CodLingua) && Objects.equals(DSLingua, that.DSLingua) && Objects.equals(DSArticoloAgg, that.DSArticoloAgg) && Objects.equals(Classificazione1, that.Classificazione1) && Objects.equals(Classificazione2, that.Classificazione2) && Objects.equals(Classificazione3, that.Classificazione3) && Objects.equals(Classificazione4, that.Classificazione4) && Objects.equals(Classificazione5, that.Classificazione5) && Objects.equals(Classificazione6, that.Classificazione6) && Objects.equals(Classificazione7, that.Classificazione7) && Objects.equals(Classificazione8, that.Classificazione8) && Objects.equals(Classificazione9, that.Classificazione9) && Objects.equals(Classificazione10, that.Classificazione10) && Objects.equals(DSAttributoMultiplo1, that.DSAttributoMultiplo1) && Objects.equals(DSAttributoMultiplo2, that.DSAttributoMultiplo2) && Objects.equals(IDArticolo, that.IDArticolo) && Objects.equals(IDLinea, that.IDLinea) && Objects.equals(IDStagione, that.IDStagione) && Objects.equals(IDTipoTaglia, that.IDTipoTaglia) && Objects.equals(IDMarca, that.IDMarca) && Objects.equals(IDCampionario, that.IDCampionario) && Objects.equals(IDMateriale, that.IDMateriale) && Objects.equals(IDTipoEtichetta, that.IDTipoEtichetta) && Objects.equals(IDCategoriaMerceologica, that.IDCategoriaMerceologica) && Objects.equals(IDSesso, that.IDSesso) && Objects.equals(IDArtCod, that.IDArtCod) && Objects.equals(IDColore, that.IDColore) && Objects.equals(IDTaglia, that.IDTaglia) && Objects.equals(Peso, that.Peso) && Objects.equals(URLImg1, that.URLImg1) && Objects.equals(URLImg2, that.URLImg2) && Objects.equals(URLImg3, that.URLImg3) && Objects.equals(URLImg4, that.URLImg4) && Objects.equals(URLImg5, that.URLImg5) && Objects.equals(Disponibilita, that.Disponibilita) && Objects.equals(PrezzoImponibileNetto, that.PrezzoImponibileNetto) && Objects.equals(ArticoloDescrizionePers, that.ArticoloDescrizionePers) && Objects.equals(RetailItalyNetto, that.RetailItalyNetto) && Objects.equals(FlagTipoArticolo, that.FlagTipoArticolo) && Objects.equals(CodAlternativo, that.CodAlternativo) && Objects.equals(FlagScontabile, that.FlagScontabile) && Objects.equals(DSArticoloAggWeb, that.DSArticoloAggWeb) && Objects.equals(DescrClass1, that.DescrClass1) && Objects.equals(DescrClass1Web, that.DescrClass1Web) && Objects.equals(DescrClass2, that.DescrClass2) && Objects.equals(DescrClass2Web, that.DescrClass2Web) && Objects.equals(DescrClass3, that.DescrClass3) && Objects.equals(DescrClass3Web, that.DescrClass3Web) && Objects.equals(Classificazione, that.Classificazione) && Objects.equals(PrezzoScontatoIvato, that.PrezzoScontatoIvato) && Objects.equals(ScontoListino, that.ScontoListino) && Objects.equals(PrezzoScontatoNetto, that.PrezzoScontatoNetto) && Objects.equals(RaggruppamentoLinea, that.RaggruppamentoLinea) && Objects.equals(IDReparto, that.IDReparto) && Objects.equals(CostoImponibileNetto, that.CostoImponibileNetto) && Objects.equals(BarcodeCustom, that.BarcodeCustom) && Objects.equals(SKUCustom, that.SKUCustom) && Objects.equals(URLImg6, that.URLImg6) && Objects.equals(URLImg7, that.URLImg7) && Objects.equals(URLImg8, that.URLImg8) && Objects.equals(URLImg9, that.URLImg9) && Objects.equals(URLImg10, that.URLImg10) && Objects.equals(EAN, that.EAN) && Objects.equals(ModelloOwner, that.ModelloOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IGUNegozio, CodNegozio, IGUArticolo, Modello, CodEsterno, DSArticolo, DSArticoloWeb, Nota, Um, UmWeb, CodIva, Continuativo, DayOne, IGULinea, DSLinea, DSLineaWeb, IGUStagione, DSStagione, DSStagioneWeb, IGUTipoTaglia, DSTipoTaglia, DSTipoTagliaWeb, IGUMarca, DSMarca, DSMarcaWeb, IGUCampionario, DSCampionario, DSCampionarioWeb, IGUMateriale, DSMateriale, DSMaterialeWeb, IGUTipoEtichetta, DSTipoEtichetta, DSTipoEtichettaWeb, IGUReparto, DSReparto, DSRepartoWeb, IGUCategoriaMerceologica, DSCategoriaMerceologica, DSCategoriaMerceologicaWeb, IGUSesso, DSSesso, DSSessoWeb, CodArticolo, BarCode, CodColore, IGUColore, DSColore, DSColoreWeb, Indice, Taglia, IGUPrezzoVendita, TipoPrezzo, DataInizio, DataFine, IGUValuta, PrezzoIvato, Imponibile, Sconto, Aliquota, Costo, Annullato, FlagEstrazioneTotale, DTEstrazione, PuntiPremio, IGULingua, CodLingua, DSLingua, DSArticoloAgg, Classificazione1, Classificazione2, Classificazione3, Classificazione4, Classificazione5, Classificazione6, Classificazione7, Classificazione8, Classificazione9, Classificazione10, DSAttributoMultiplo1, DSAttributoMultiplo2, IDArticolo, IDLinea, IDStagione, IDTipoTaglia, IDMarca, IDCampionario, IDMateriale, IDTipoEtichetta, IDCategoriaMerceologica, IDSesso, IDArtCod, IDColore, IDTaglia, Peso, URLImg1, URLImg2, URLImg3, URLImg4, URLImg5, Disponibilita, PrezzoImponibileNetto, ArticoloDescrizionePers, RetailItalyNetto, FlagTipoArticolo, CodAlternativo, FlagScontabile, DSArticoloAggWeb, DescrClass1, DescrClass1Web, DescrClass2, DescrClass2Web, DescrClass3, DescrClass3Web, Classificazione, PrezzoScontatoIvato, ScontoListino, PrezzoScontatoNetto, RaggruppamentoLinea, IDReparto, CostoImponibileNetto, BarcodeCustom, SKUCustom, URLImg6, URLImg7, URLImg8, URLImg9, URLImg10, EAN, ModelloOwner);
    }
}
