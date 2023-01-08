import {useState} from "react";
import {Button, TextField} from "@mui/material";
import api from "../../services/api";
import {useNavigate} from "react-router-dom";

const SpremeniProfil = () => {
    const [id, setId] = useState(0);
    const [ime, setIme] = useState("");
    const [priimek, setPriimek] = useState("");
    const [starost, setStarost] = useState(0);
    const navigate = useNavigate();
    const spremeniProfil = () => {
        api.put(`/profili/spremeni/${id}`, {
            ime: ime,
            priimek: priimek,
            starost: starost
        });
    }
    return(
        <>
            <p>Spremeni profil (spreminjamo lahko samo ime, ker je tako implementirano v backendu)</p>
            Id profila: <TextField variant="standard" value={id} onChange={(e) => setId(e.target.value)}/><br />
            Ime: <TextField variant="standard" value={ime} onChange={(e) => setIme(e.target.value)}/><br />
            Priimek: <TextField variant="standard" value={priimek} onChange={(e) => setPriimek(e.target.value)}/><br />
            Starost: <TextField variant="standard" value={starost} onChange={(e) => setStarost(e.target.value)}/><br />
            <Button variant="contained" onClick={() => spremeniProfil()}>Spremeni profil</Button>
            <Button variant="contained" onClick={() => navigate("/profili")}>Nazaj na vse profile</Button>
        </>
    );
}
export default SpremeniProfil;