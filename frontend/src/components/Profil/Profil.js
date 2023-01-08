import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import api from "../../services/api";
import {Button} from "@mui/material";

const Profil = () => {
    const [profili, setProfil] = useState([]);
    let navigate = useNavigate();
    useEffect(() => {
        const pridobiProfile = () => {
            api.get("/profili").then((odgovor) => {
                setProfil(odgovor.data);
                console.log(odgovor);
            })
        }
        pridobiProfile();
    }, []);
    return(
        <>
            <h1>Vsi profili</h1>
            {
                profili.map((profil) => {
                    return(
                        <span key={profil.id}>
                            <p>{profil.ime} - {profil.priimek} - {profil.starost}</p>
                        </span>
                    );
                })
            }
            <Button variant="contained" onClick={() => navigate("/")}>Nazaj na zacetno stran</Button>
            <Button variant="contained" onClick={() => navigate("/profili/dodaj")}>Dodaj profil</Button>
            <Button variant="contained" onClick={() => navigate("/profili/spremeni")}>Spremeni profil</Button>
            <Button variant="contained" onClick={() => navigate("/profili/izbrisi")}>Izbrisi profil</Button>
        </>
    );
}

export default Profil;