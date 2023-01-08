import React, {useState} from "react";
import api from "../../services/api";
import {Button, TextField} from "@mui/material";
import {useNavigate} from "react-router-dom";

const DodajUporabnika = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [geslo, setGeslo] = useState("");
    let navigate = useNavigate();

    const dodajUporabnika = () => {
    api.post("/uporabniki", {
        username: username,
        email: email,
        geslo: geslo
        }).then((odgovor) => console.log(odgovor));
    }

    return(
        <div>
            <p>Dodaj uporabnika: </p>
            Uporabniško ime: <TextField variant="standard" value={username} onChange={(e) => setUsername(e.target.value)}/><br />
            Email: <TextField variant="standard" value={email} onChange={(e) => setEmail(e.target.value)}/><br />
            Geslo: <TextField variant="standard" value={geslo} onChange={(e) => setGeslo(e.target.value)}/><br />
            <Button variant="contained" onClick={dodajUporabnika}>Dodaj uporabnika</Button>
            <Button variant="contained" onClick={() => navigate("/uporabniki")}>Nazaj na vse uporabnike</Button>
        </div>
    );
}
export default DodajUporabnika;