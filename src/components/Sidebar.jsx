import { Drawer, List, ListItem, ListItemIcon, ListItemText, Toolbar } from '@mui/material'
import { School, Book, ExitToApp } from '@mui/icons-material'
import { useNavigate } from 'react-router-dom'

const drawerWidth = 240

const Sidebar = () => {
  const navigate = useNavigate()

  const menuItems = [
    { text: 'Mes Notes', icon: <Book />, path: '/dashboard' },
    { text: 'Profil', icon: <School />, path: '/dashboard/profile' },
    { text: 'Déconnexion', icon: <ExitToApp />, onClick: () => {
      localStorage.removeItem('token');
      window.location.href = '/';
    }}
  ]

  return (
    <Drawer
      variant="permanent"
      sx={{
        width: drawerWidth,
        flexShrink: 0,
        [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
      }}
    >
      <Toolbar />
      <List>
        {menuItems.map((item) => (
          <ListItem 
            button 
            key={item.text}
            onClick={item.onClick || (() => navigate(item.path))}
          >
            <ListItemIcon>{item.icon}</ListItemIcon>
            <ListItemText primary={item.text} />
          </ListItem>
        ))}
      </List>
    </Drawer>
  )
}

export default Sidebar
