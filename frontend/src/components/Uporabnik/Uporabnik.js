import React, {useEffect, useState} from 'react';
import api from "../../services/api";
import {useNavigate} from "react-router-dom";
import {Button} from "@mui/material";

const Uporabnik = () => {
    const[uporabniki, setUporabniki] = useState([]);
    let navigate = useNavigate();
    useEffect(() => {
        const pridobiUporabnike = () => {
            api.get("/uporabniki").then((odgovor) => {
                setUporabniki(odgovor.data);
                console.log(odgovor);
            });
        }
        pridobiUporabnike();
    }, []);
    return(
        <>
            <h1>Vsi uporabniki</h1>
            {
                uporabniki.map((uporabnik) => {
                        return(
                            <span key={uporabnik.id}>
                                <span>{uporabnik.username} -- {uporabnik.email}</span> <br />
                            </span>

                        );
                    }
                )
            }
            <Button variant="contained" onClick={() => navigate("/uporabniki/dodaj")}>Dodaj uporabnika</Button>
            <Button variant="contained" onClick={() => navigate("/uporabniki/spremeni")}>Spremeni uporabnika</Button>
            <Button variant="contained" onClick={() => navigate("/uporabniki/izbrisi")}>Izbrisi uporabnika</Button>
            <Button variant="contained" onClick={() => navigate("/")}>Nazaj na zacetno stran</Button>
        </>
    );
}
export default Uporabnik;
/*
export default function Uporabnik(){
    return (
        <>
            <p>nekaj</p>
        </>
    );
}

 */