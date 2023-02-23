import { Routes, Route } from 'react-router-dom'
import {Home }from './pages/Home'
import { Store } from './pages/Store'
import {About }from './pages/About'
import {Navbar} from './components/NavBar'
function App() {  
    return  (    
        <div className="container mx-auto  ">
    <>
       <Navbar />
        <Routes>
            <Route path="/main/home" element={<Home/>}/>
            <Route path="/main/store" element={<Store/>}/>
            <Route path="/main/about" element={<About/>}/>
        </Routes>
    </>
        </div>
    
  )
}

export default App
