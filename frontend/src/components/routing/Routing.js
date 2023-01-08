import React from "react";
import {Route, Routes} from "react-router-dom";
import Uporabnik from "../Uporabnik/Uporabnik";
import DodajUporabnika from "../Uporabnik/DodajUporabnika"
import SpremeniUporabnika from "../Uporabnik/SpremeniUporabnika"
import IzbrisiUporabnika from "../Uporabnik/IzbrisiUporabnika"
import ZacetnaStran from "../ZacetnaStran";
import Profil from "../Profil/Profil";
import DodajProfil from "../Profil/DodajProfil";
import SpremeniProfil from "../Profil/SpremeniProfil";
import IzbrisiProfil from "../Profil/IzbrisiProfil";

export default function Routing(){
    return(
        <Routes>
            <Route path="/" element={<ZacetnaStran/>} />
            <Route path="/uporabniki" element={<Uporabnik />}/>
            <Route path="/uporabniki/dodaj" element={<DodajUporabnika />}/>
            <Route path="/uporabniki/spremeni" element={<SpremeniUporabnika />}/>
            <Route path="/uporabniki/izbrisi" element={<IzbrisiUporabnika />}/>
            <Route path="/profili" element={<Profil />}/>
            <Route path="/profili/dodaj" element={<DodajProfil />}/>
            <Route path="/profili/spremeni" element={<SpremeniProfil />}/>
            <Route path="/profili/izbrisi" element={<IzbrisiProfil />}/>
        </Routes>
    );
}