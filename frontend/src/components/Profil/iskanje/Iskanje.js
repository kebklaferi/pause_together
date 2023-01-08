import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {Button, TextField} from "@mui/material";
import api from "../../../services/api";

const Iskanje = () => {
    const [starost, setStarost] = useState(0);
    const [dolzina, setDolzina] = useState(0);
    const [crka, setCrka] = useState("");
    const [rezultati, setRezultate] = useState([]);
    const navigate = useNavigate();

    const isci = () => {
        api.get(`profili/param?starost=${starost}&d_ime=${dolzina}&zacetnica_priimek=${crka}`)
            .then((odgovor) => {
            setRezultate(odgovor.data);
            console.log(odgovor.data);
        });
    }
    return(
        <>
            <p>starejsi od podane letnice, dolzina imena je vsaj ali vecja kot podana, priimek zacne na podano crko</p>
            Starost: <TextField variant="standard" value={starost} onChange={(e) => setStarost(e.target.value)}/><br />
            Dolzina: <TextField variant="standard" value={dolzina} onChange={(e) => setDolzina(e.target.value)}/><br />
            Črka: <TextField variant="standard" value={crka} onChange={(e) => setCrka(e.target.value)}/><br /><p></p>
            {
                rezultati.map((rezultat) => {
                    return(
                        <div key={rezultat.id}>
                            <li>{rezultat.ime} - {rezultat.priimek} - {rezultat.starost}</li>
                        </div>
                    );
                })
            }
            <p></p>
            <Button variant="contained" onClick={isci}>Isci</Button>
            <Button variant="contained" onClick={() => navigate("/")}>Nazaj na zacetno stran</Button>
        </>
    );
}
export default Iskanje;