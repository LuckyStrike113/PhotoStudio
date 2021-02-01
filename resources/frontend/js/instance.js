const METHODS = {
  GET: 'GET',
  PUT: 'PUT',
  POST: 'POST',
  DELETE: 'DELETE'
}

const request = (method) => {
  return (url, data) => {
      let options = {
      method,
      headers: {
        'X-Requested-With': 'XMLHttpRequest',
        'Content-Type': 'application/json'
      }
    };

    if(data) {
      options.body = JSON.stringify(data);
    }

    return fetch(url, { ...options }).then(data => data.json());
  };
};

const $get = request(METHODS.GET);
const $put =  request(METHODS.PUT);
const $post = request(METHODS.POST);
const $delete = request(METHODS.DELETE);
