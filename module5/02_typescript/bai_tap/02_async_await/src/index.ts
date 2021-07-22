console.log('Start');

// let promiseObj = new Promise(function (resolve, reject) {
//     let xHttp = new XMLHttpRequest();
//     xHttp.onload =function () {
//         if(this.status == 200){
//             resolve(xHttp.responseText);
//         } else {
//             reject("Error call API");
//         }
//     };
//     xHttp.open("GET", "https://api.github.com/search/repositories?q=angular");
//     xHttp.send();
// });
// promiseObj.then((result) => {
//    console.log("OK");
//    console.log(result);
// }, (error)=> {
//     console.log("pending");
//     }).finally(()=> {console.log("End")});

async function searchGithub() {
    return await new Promise(function (resolve, reject) {
        let xHttp = new XMLHttpRequest();
        xHttp.onload =function () {
            if(this.status == 200){
                resolve(xHttp.responseText);
            } else {
                reject("Error call API");
            }
        };
        xHttp.open("GET", "https://api.github.com/search/repositories?q=angular");
        xHttp.send();
    });
}
searchGithub().then(function (result) {
    console.log("OK");
    console.log(result);
}).finally(()=>{console.log("End")});
