function fibonacci(num) {
    if (num == 0) {
        return 0;
    }
    if (num == 1) {
        return 1;
    }
    return fibonacci(num - 2) + fibonacci(num - 1);
}
let num = 0;
let s = 0;
for (let i = 0; i < 10; i++) {
    s = fibonacci(i);
    num += s;
    console.log(s);
}
console.log("Tong cua day 10 so trong fibonacci la: " + num);
//# sourceMappingURL=main.js.map