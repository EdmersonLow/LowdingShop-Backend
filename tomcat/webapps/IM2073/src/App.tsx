import { Routes, Route } from 'react-router-dom'
import {Home }from './pages/Home'
import {Store } from './pages/Store'
import {About }from './pages/About'
import { Navbar } from './components/Navbar'
function App() {  
    return  (    
        <div className="container mx-auto  ">
    <>
       <Navbar />
        <Routes>
            <Route path="/home" element={<Home/>}/>
            <Route path="/store" element={<Store/>}/>
            <Route path="/about" element={<About/>}/>
        </Routes>
    </>
        </div>
    
  )
}

export default App
