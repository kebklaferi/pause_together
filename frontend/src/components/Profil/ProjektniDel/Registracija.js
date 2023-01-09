import {useNavigate} from "react-router-dom";
import {Button, TextField} from "@mui/material";
import api from "../../../services/api";
import {useState} from "react";

const Registracija = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [geslo, setGeslo] = useState("");
    let navigate = useNavigate();

    const registriraj = () => {
        api.post("/uporabniki/registracija", {
            username: username,
            email: email,
            geslo: geslo
        }).then((odgovor) => console.log(odgovor.data));
    }

    return(
        <div>
            <p>Registriraj uporabnika: </p>
            Uporabniško ime: <TextField variant="standard" value={username} onChange={(e) => setUsername(e.target.value)}/><br />
            Email: <TextField variant="standard" value={email} onChange={(e) => setEmail(e.target.value)}/><br />
            Geslo: <TextField variant="standard" value={geslo} onChange={(e) => setGeslo(e.target.value)}/><br />
            <Button variant="contained" onClick={registriraj}>Registriraj</Button>
            <Button variant="contained" onClick={() => navigate("/")}>Nazaj na zacetni zaslon</Button>
        </div>
    );
}

export default Registracija;