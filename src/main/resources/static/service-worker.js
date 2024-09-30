/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

self.addEventListener("install", event => {
    event.waitUntil(
            caches.open("v1")
            .then(cache => cache.addAll(["index.html"]))
            .catch(error => console.error(error)));
});