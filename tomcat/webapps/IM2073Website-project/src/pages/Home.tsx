export function Home(){ 
    return (
        <div>
    <h2>One More Bookshop</h2><form method="get" action="http://localhost:8888/main/query">
            <b>Choose an author:</b>
            <input type="checkbox" name="author" value="Tan Ah Teck" />Ah Teck
            <input type="checkbox" name="author" value="Mohammad Ali" />Ali
            <input type="checkbox" name="author" value="Kumar" />Kumar
            <input type="submit" value="Search" />
        </form>
    </div>
    
    );
};