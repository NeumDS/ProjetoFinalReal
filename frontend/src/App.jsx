
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/dashboard" replace />} />

        <Route path="/dashboard" element={<h1>Dashboard</h1>} />
        <Route path="/quartos" element={<h1>Quartos</h1>} />
        <Route path="/hospedes" element={<h1>Hóspedes</h1>} />
        <Route path="/reservas" element={<h1>Reservas</h1>} />
        <Route path="/servicos" element={<h1>Serviços</h1>} />
        <Route path="/tipos-quarto" element={<h1>Tipos de Quarto</h1>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
