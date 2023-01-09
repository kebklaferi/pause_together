import {useState} from "react";
import api from "../../../services/api";
import {Button, TextField} from "@mui/material";
import {useNavigate} from "react-router-dom";

const Prijava = () => {
    const [email, setEmail] = useState("");
    const [geslo, setGeslo] = useState("");
    const navigate = useNavigate();
    const prijava = () => {
        api.post("uporabniki/prijava", {
            geslo: geslo,
            email: email
        }).then((odgovor) => console.log(odgovor.data));
    }
    return(
        <>
            <p>Prijava: </p>
            Email: <TextField variant="standard" value={email} onChange={(e) => setEmail(e.target.value)}/><br />
            Geslo: <TextField variant="standard" value={geslo} onChange={(e) => setGeslo(e.target.value)}/><br />
            <Button variant="contained" onClick={prijava}>Prijava</Button>
            <Button variant="contained" onClick={() => navigate("/")}>Nazaj na zacetni zaslon</Button>
        </>
    );
}

export default Prijava;