import MainNavigation from "./MainNavigation";
import styles from "./Layout.module.css";

function Layout(props) {
    return <div>
        <MainNavigation />
        <main className={styles.main}>
            {props.children}
        </main>
    </div>

}
export default Layout;
//{props.children} spits out all the jsx data that exists between wherever this Layout component is being used,
//this way we can use this component as a style wrapper and if we didn't use props.children, all the jsx content that
//sat between this Layout component would have just been erased and replaced with whatever jsx is in the component itself
//Example:
//<Layout>
//  <div> <--- doesn't get erased
//      <h1>Data</h1> <---
//  </div> <---
//</Layout>