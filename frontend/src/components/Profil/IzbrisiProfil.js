import {useState} from "react";
import {useNavigate} from "react-router-dom";
import api from "../../services/api";
import {Button, TextField} from "@mui/material";

const IzbrisiProfil = () => {
    const [id, setId] = useState(0);
    const navigate = useNavigate();

    const izbrisiProfil = () => {
        api.delete(`/profili/izbrisi/${id}`)
            .then((odgovor) => console.log(odgovor));
    }
    return(
        <>
            <p>Izbrisi profil</p>
            Id profila: <TextField variant="standard" value={id} onChange={(e) => setId(e.target.value)}/><br />
            <Button variant="contained" onClick={() => izbrisiProfil()}>Izbrisi</Button>
            <Button variant="contained" onClick={() => navigate("/profili")}>Nazaj na vse profile</Button>
        </>
    );
}

export default IzbrisiProfil;