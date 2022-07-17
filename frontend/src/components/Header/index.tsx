import "./styles.css"
import logo from "../../assets/img/logo.svg"

function Header() {
    return (
        <header>
            <div className="logo-container">
                <img src={logo} alt="MySales"/>
                <h1>MySales</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.linkedin.com/in/harley-ferreira-93532a15b/"> @Harley</a>
                </p>
            </div>
        </header>
    )
}

export default Header