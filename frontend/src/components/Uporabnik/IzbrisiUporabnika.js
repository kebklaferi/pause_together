import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import api from "../../services/api";
import {Button, TextField} from "@mui/material";

const IzbrisiUporabnika = () => {
    const [id, setId] = useState(0);
    let navigate = useNavigate();

    const izbrisiUporabnika = () => {
        api.delete(`/uporabniki/izbrisi/${id}`)
            .then((odgovor) => console.log(odgovor.data));
    }
    return(
        <>
            <p>Izbrisi uporabnika: </p><br />
            Id uporabnika: <TextField variant="standard" value={id} onChange={(e) => setId(e.target.value)}/><br />
            <Button variant="contained" onClick={() => izbrisiUporabnika()}>Izbrisi</Button>
            <Button variant="contained" onClick={() => navigate("/uporabniki")}>Nazaj na vse uporabnike</Button>
        </>
    );
}
export default IzbrisiUporabnika;