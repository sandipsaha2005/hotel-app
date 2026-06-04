const sleep = async () => {
    return new Promise(res => {
        setTimeout(() =>res(10000), 10000);
    })
}

export const generatePDF = async (client) => {
    const queueName = "pdf-generator";
    console.log("====> worker started <====");
    while (true) {
        console.log("====> INside loop <====")
        const x = await client.brPop(queueName, 0);
        console.log("====> recieved job <====")

        await sleep();
        console.log(x);
    }
}