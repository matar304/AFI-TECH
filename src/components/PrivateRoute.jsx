import { Navigate } from "react-router-dom";
import authService from "../services/authService";

const PrivateRoute = ({ children, requiredRole }) => {
  if (!authService.isAuthenticated()) {
    return <Navigate to="/connexion" replace />;
  }

  if (requiredRole && !authService.hasRole(requiredRole)) {
    return <Navigate to="/" replace />;
  }

  return children;
};

export default PrivateRoute;
