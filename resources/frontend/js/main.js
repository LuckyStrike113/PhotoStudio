const ENDPOINTS = {
    CONTACTS: "contacts",
    HALLS: "halls",
    GALLERY: "halls/gallery?size=50",
};

const IDS = {
    HALLS_PICTURE: "halls_picture",
    SERVICES_INFO: "services_info",
    SERVICES_INFO_NIGHT: "service-info_night-package",
    CONTACTS_LIST: "contacts_list",
    GALLERY_PICTURE: "gallery-pic",
}

const HALLS_IDS = {
    PLAZA: "27539049-4328-40bd-b000-c8a2b31057cc",
    LOFT: "69caaf61-42ec-4f6f-83ab-3feae6e64ab9",
    ROYAL: "a870d9e7-2703-442b-904b-2d323e11a145"
}

const HALLS_HTML = {
    PLAZA: "plaza.html",
    LOFT: "loft.html",
    ROYAL: "royal.html"
}

const SERVICES_STATE = {
    NIGHT: "NIGHT",
    DAY: "DAY"
}

const host = "http://localhost:8080";


window.addEventListener("load", async function(event) {
    const contactsResponse = await $get(`${host}/${ENDPOINTS.CONTACTS}`);
    const hallsResponse = await $get(`${host}/${ENDPOINTS.HALLS}`);
    const galleryResponse = await $get(`${host}/${ENDPOINTS.GALLERY}`);

    if(contactsResponse) {
        const contacts = contactsResponse.content;
        insertContacts(contacts);
    }

    if(hallsResponse) {
        const serviceList = hallsResponse.content;
        insertServices(serviceList);
        insertHallsPicture(serviceList);
    }

    if(galleryResponse) {
        const galleryList = galleryResponse.content;
        const pathname = document.location.pathname.split("/");
        const pathnameLength = pathname.length;
        const page = pathname[pathnameLength-1];

        switch (page) {
            case HALLS_HTML.LOFT:
                insertGalleries(galleryList, HALLS_IDS.LOFT); break;
            case HALLS_HTML.PLAZA:
                insertGalleries(galleryList, HALLS_IDS.PLAZA); break;
            case HALLS_HTML.ROYAL:
                insertGalleries(galleryList, HALLS_IDS.ROYAL); break;
        }
    }
});

function insertContacts(contacts) {
    const ul = document.getElementById(IDS.CONTACTS_LIST);

    if(ul && !!contacts) {
        contacts.map(item => {
            const li = document.createElement("li");

            li.innerHTML = `${item.number} - ${item.description}`;
            li.classList.add("list-group-item");
            ul.appendChild(li);
        });
    }
}

function insertServices(services) {
    const tbodyNight = document.getElementById(IDS.SERVICES_INFO_NIGHT);
    const tbodyDay = document.getElementById(IDS.SERVICES_INFO);

    if(!!tbodyDay && !!tbodyNight && !!services) {
        services.map(item => {
            const tr = document.createElement("tr");
            const td1 = document.createElement("td");
            const td2 = document.createElement("td");
            const td3 = document.createElement("td");

            td1.innerHTML = item.name;
            td2.innerHTML = `${item.weekdayCost} BYN/hour`;
            td3.innerHTML = `${item.weekendCost} BYN/hour`;

            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);

            if(item.timeStatus === SERVICES_STATE.NIGHT) {
                tbodyNight.parentNode.insertBefore(tr, tbodyNight.nextSibling);
            } else {
                tbodyDay.appendChild(tr);
            }
        });
    }
}

function insertGalleries(gallery, page_ids) {
    const container = document.getElementById(IDS.GALLERY_PICTURE);

    if(!!container && !!gallery) {
        gallery.map(item => {
            if(item.hall_id === page_ids) {
                const wrapper = document.createElement("div");
                const picture = document.createElement("div");

                wrapper.classList.add("col-4", "px-1");
                picture.classList.add("col-12", "pic", "halls-picture", item.image);

                wrapper.appendChild(picture);
                container.appendChild(wrapper);
            }
        });
    }
}

function insertHallsPicture(serviceProps) {
    const container = document.getElementById(IDS.HALLS_PICTURE);

    if(!!serviceProps && !!container) {
        serviceProps.map(item => {
            const { imageLink, image } = item;

            if(imageLink && image) {
                const link = document.createElement("a");
                const picture = document.createElement("div");

                link.classList.add("col-lg-4", "mt-3");
                picture.classList.add("pic", image);

                link.href = imageLink;
                link.appendChild(picture);
                container.appendChild(link);
            }
        });
    }
}
