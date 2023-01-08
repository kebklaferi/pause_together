import React, {useState} from "react";
import api from "../../services/api";
import {Button, TextField} from "@mui/material";
import {useNavigate} from "react-router-dom";

const SpremeniUporabnika = () => {
    const [id, setId] = useState(0);
    const [username, setNovUsername] = useState("");
    const [email, setNoviMail] = useState("");
    let navigate = useNavigate();
    const spremeniUporabnika = () => {
        api.put(`/uporabniki/spremeni/${id}`, {
            username: username,
            email: email
        });
    }
    return(
        <>
            <p>Spremeni uporabnika</p>
            Id uporabnika: <TextField variant="standard" value={id} onChange={(e) => setId(e.target.value)}/><br />
            Uporabniško ime: <TextField variant="standard" value={username} onChange={(e) => setNovUsername(e.target.value)}/><br />
            Email: <TextField variant="standard" value={email} onChange={(e) => setNoviMail(e.target.value)}/><br />
            <Button variant="contained" onClick={() => spremeniUporabnika()}>Spremeni uporabnika</Button>
            <Button variant="contained" onClick={() => navigate("/uporabniki")}>Nazaj na vse uporabnike</Button>
        </>
    );
}
export default SpremeniUporabnika;