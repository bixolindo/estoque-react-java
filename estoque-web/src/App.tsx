import { ThemeProvider } from 'styled-components';
import './App.css';
import GlobalStyle from './globalStyle';
import Dashboard from './pages/dashboard/dashboard';
import theme from './theme';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Dashboard />
    </ThemeProvider>
  );
}

export default App;
