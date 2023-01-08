import {Button} from "@mui/material";
import React from "react";
import {useNavigate} from "react-router-dom";

const ZacetnaStran = () => {
    const navigate = useNavigate();
    return (
        <>
            <h1>Pause Together</h1>
            <Button variant="contained" onClick={() => navigate("/uporabniki")}>Uporabniki</Button>
            <Button variant="contained" onClick={() => navigate("/profili")}>Profili</Button>
            <Button variant="contained" onClick={() => navigate("/iskanje")}>Iskanje</Button>
        </>
    );
}

export default ZacetnaStran;