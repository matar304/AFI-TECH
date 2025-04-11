import React from "react";
import { useNavigate } from "react-router-dom";
import "./HomePage.css";

const HomePage = () => {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <header className="header">
        <button className="login-icon" onClick={() => navigate("/connexion")}>
          <i className="fas fa-sign-in-alt"></i>
        </button>
      </header>

      <main className="main-content">
        <h1>Bienvenue à AFI-TECH</h1>
      </main>
    </div>
  );
};

export default HomePage;
