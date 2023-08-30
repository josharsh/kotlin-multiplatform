(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'kmp-shared'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'kmp-shared'.");
    }
    root['kmp-shared'] = factory(typeof this['kmp-shared'] === 'undefined' ? {} : this['kmp-shared'], kotlin);
  }
}(this, function (_, Kotlin) {
  'use strict';
  var Kind_INTERFACE = Kotlin.Kind.INTERFACE;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var NotImplementedError_init = Kotlin.kotlin.NotImplementedError;
  function Base64Encoder() {
  }
  Base64Encoder.$metadata$ = {
    kind: Kind_INTERFACE,
    simpleName: 'Base64Encoder',
    interfaces: []
  };
  function Base64Factory() {
    Base64Factory_instance = this;
  }
  Base64Factory.prototype.createEncoder = function () {
    throw new NotImplementedError_init('An operation is not implemented: ' + 'Not yet implemented');
  };
  Base64Factory.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'Base64Factory',
    interfaces: []
  };
  var Base64Factory_instance = null;
  function Base64Factory_getInstance() {
    if (Base64Factory_instance === null) {
      new Base64Factory();
    }
    return Base64Factory_instance;
  }
  var package$com = _.com || (_.com = {});
  var package$plumhq = package$com.plumhq || (package$com.plumhq = {});
  var package$employee = package$plumhq.employee || (package$plumhq.employee = {});
  package$employee.Base64Encoder = Base64Encoder;
  Object.defineProperty(package$employee, 'Base64Factory', {
    get: Base64Factory_getInstance
  });
  Kotlin.defineModule('kmp-shared', _);
  return _;
}));

//# sourceMappingURL=kmp-shared.js.map
