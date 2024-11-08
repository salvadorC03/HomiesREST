/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

self.addEventListener("install", event => {
    console.log("Installed service worker succesfully");
});

const publicKey = "23146fd000268fddf4bb67c6e8cd811e76d0f9c0";
const privateKey = "3878cf697b21395034060c70a17f1fed";

const urlB64ToUint8Array = base64String => {
    const padding = '='.repeat((4 - (base64String.length % 4)) % 4);
    const base64 = (base64String + padding).replace(/\-/g, '+').replace(/_/g, '/');
    const rawData = atob(base64);
    const outputArray = new Uint8Array(rawData.length);
    for (let i = 0; i < rawData.length; ++i) {
        outputArray[i] = rawData.charCodeAt(i);
    }
    return outputArray;
};

self.addEventListener("activate", async (event) => {
    try {
        const applicationServerKey = urlB64ToUint8Array(publicKey);
        const options = {applicationServerKey, userVisibleOnly: true};
        const subscription = await self.registration.pushManager.subscribe(options);


        console.log("Subscribed to Push Manager", JSON.stringify(subscription));
    } catch (err) {
        console.log('Error', err);
    }
});