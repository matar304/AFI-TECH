import axios from 'axios';

const API_URL = 'http://localhost:9090/api/auth';

const authService = {
  login: async (credentials) => {
    const response = await axios.post(`${API_URL}/login`, credentials);
    if (response.data.token) {
      localStorage.setItem('user', JSON.stringify({
        token: response.data.token,
        roles: response.data.roles
      }));
    }
    return response.data;
  },

  logout: () => {
    localStorage.removeItem('user');
  },

  getCurrentUser: () => {
    return JSON.parse(localStorage.getItem('user'));
  },

  isAuthenticated: () => {
    const user = JSON.parse(localStorage.getItem('user'));
    return user && user.token;
  },

  hasRole: (role) => {
    const user = JSON.parse(localStorage.getItem('user'));
    return user?.roles?.includes(role);
  },

  // Student management functions
  getStudents: async () => {
    const user = JSON.parse(localStorage.getItem('user'));
    const response = await axios.get('http://localhost:9090/api/students', {
      headers: {
        'Authorization': `Bearer ${user.token}`
      }
    });
    return response.data;
  },

  addStudent: async (studentData) => {
    const user = JSON.parse(localStorage.getItem('user'));
    const response = await axios.post('http://localhost:9090/api/students', studentData, {
      headers: {
        'Authorization': `Bearer ${user.token}`
      }
    });
    return response.data;
  },

  deleteStudent: async (studentId) => {
    const user = JSON.parse(localStorage.getItem('user'));
    const response = await axios.delete(`http://localhost:9090/api/students/${studentId}`, {
      headers: {
        'Authorization': `Bearer ${user.token}`
      }
    });
    return response.data;
  }
};

export default authService;
