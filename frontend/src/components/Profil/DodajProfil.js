import {useState} from "react";
import {useNavigate} from "react-router-dom";
import api from "../../services/api";
import {Button, TextField} from "@mui/material";

const DodajProfil = () => {
    const [ime, setIme] = useState("");
    const [priimek, setPriimek] = useState("");
    const [starost, setStarost] = useState(0);
    let navigate = useNavigate();

    const dodajProfil = () => {
        api.post("/profili", {
            ime: ime,
            priimek: priimek,
            starost: starost
        }).then((odgovor) => console.log(odgovor));
    }
    return(
        <>
            <div>
                <p>Dodaj profil</p>
                Ime: <TextField variant="standard" value={ime} onChange={(e) => setIme(e.target.value)}/><br />
                Priimek: <TextField variant="standard" value={priimek} onChange={(e) => setPriimek(e.target.value)}/><br />
                Starost: <TextField variant="standard" value={starost} onChange={(e) => setStarost(e.target.value)}/><br />
                <Button variant="contained" onClick={dodajProfil}>Dodaj profil</Button>
                <Button variant="contained" onClick={() => navigate("/profili")}>Nazaj na vse profile</Button>
            </div>
        </>
    );
}
export default DodajProfil;