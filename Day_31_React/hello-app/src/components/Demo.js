import Hello from './Hello';

// function Demo() {
//     return (
//         <h3>But, he's boring</h3>
//     );
// }   

//or

const Demo = () => {
    return (
        <div>
        <h3>**** it renders from Component->demo.js and call hello ***** from demo.js****</h3>
        <Hello name="harsh"/>
        </div>
    );
}

export default Demo